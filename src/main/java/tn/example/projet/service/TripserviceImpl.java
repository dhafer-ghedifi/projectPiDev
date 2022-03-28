package tn.example.projet.service;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import tn.example.projet.DTO.CountTrip;
import tn.example.projet.model.Employee;
import tn.example.projet.model.Entreprise;
import tn.example.projet.model.Participation;
import tn.example.projet.model.Rating;
import tn.example.projet.model.Trip;
import tn.example.projet.repository.EmployeeRepository;
import tn.example.projet.repository.EntrepriseRepository;
import tn.example.projet.repository.ParticipationRepository;
import tn.example.projet.repository.RatingRepository;
import tn.example.projet.repository.TripRepository;

@Service
public class TripserviceImpl implements ITripservice{
	
	@Autowired
	TripRepository tripRepository;
	@Autowired
	ParticipationRepository participationRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<Trip> retrieveAllTrips() {
		List<Trip>Trips=new ArrayList<Trip>();
		 tripRepository.findAll().forEach(Trip -> {
			 Trips.add(Trip);
	        });
	        return Trips;
	}

	@Override
	public Trip addTrip(Trip TR) {
		
		return tripRepository.save(TR);
	}

	@Override
	public void deleteTrip(Integer id) {
		tripRepository.deleteById(id);
		
	}

	@Override
	public Trip updateTrip(Trip TR) {
		return tripRepository.save(TR);
	}
	
	@Override
	public List<Trip> getTripByDestination(String Name) {
		List<Trip>Trips=new ArrayList<>();
		 {
			tripRepository.getTripByDestination(Name).forEach(Trips::add
		        );
		}
		return Trips;
	}

    @Override
	public List<CountTrip> getPercentageTripByObject() {
		return tripRepository.getPercentageByObject();
	}
	
	@Override
	public Participation addParticipation(int tripId, int employeeId) throws Exception {
		Trip TR= tripRepository.findById(tripId).orElseThrow(()->new IllegalArgumentException("no voyage with id ="+tripId));
		Employee e= employeeRepository.findById(employeeId).orElseThrow(()->new IllegalArgumentException("no employee with id="+employeeId));
		List<Participation> listOfParticipation=e.getParticipation().stream().filter(p->{
			if(p.getTrips().getArrivalDate().before(TR.getDepartureDate()) ||  p.getTrips().getDepartureDate().after(TR.getArrivalDate())){
				return false;
			}
			return true;
		}).collect(Collectors.toList());
		if(listOfParticipation.size()>0){
			throw new Exception("Employe possÃ©de un voyage dÃ©ja");
		}
		Participation participation = new Participation();
		participation.setEmployees(e);
		participation.setTrips(TR);
		sendEmail(e);
		return participationRepository.save(participation);
		
	}
	
	
	
	@Override
	public List<Employee> findEmployeeAffectedToVoyageByEntrepriseId(int entrepriseId) {
		Entreprise entreprise=entrepriseRepository.findById(entrepriseId).orElseThrow(()->new IllegalArgumentException("No entreprise found with id = "+entrepriseId));
		return entreprise.getEmployees().stream().filter(e->
			 e.getParticipation().size()>0
		).collect(Collectors.toList());
	}
	@Scheduled(cron = "*/5 * * * * *" )
		@Override
		public void updateNbreIntervenant() {
			// TODO Auto-generated method stub
			List<Participation> participations=   RetrieveAllParticipationss();
			for (Participation pp :participations)
			{
				int idTR= pp.getTrips().getIdTrip();
				Trip TR = tripRepository.findById(idTR).orElse(null);
				TR.setNbIntervenant(tripRepository.getNbreIntervenant(idTR));
				tripRepository.save(TR);
			}
			
		}

		@Override
		public List<Participation> RetrieveAllParticipationss() {
			// TODO Auto-generated method stub
			return (List<Participation>) participationRepository.findAll();
		}

		@Override
		public void voterTrip(int tripId, int employeId,float quality_of_our_service ) {
			Trip TR= tripRepository.findById(tripId).orElseThrow(()->new IllegalArgumentException("no trip with id ="+tripId));
			Employee e= employeeRepository.findById(employeId).orElseThrow(()->new IllegalArgumentException("no employee with id ="+employeId));
			Rating rate=new Rating();
			rate.setQuality_of_our_service(quality_of_our_service);
			
			rate.setEmployee(e);
			rate.setTrip(TR);
			ratingRepository.save(rate);
			
		}

		@Override
		public Float getMoyenneVote(int tripId) {
			Trip TR= tripRepository.findById(tripId).orElseThrow(()->new IllegalArgumentException("no voyage with id ="+tripId));
			if(TR.getRatings().size()==0){
				return (float) 0;
			}
			float QS=0;
			
				for (Rating rate : TR.getRatings()) {
					QS+=rate.getQuality_of_our_service();
				}
			QS=QS/TR.getRatings().size();
			
			
			return QS;
			

		}
	
	
	
	@Override
    public BufferedImage generateQRCode(String urlText) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("fronturl/trip/"+urlText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
	public void sendEmail (Employee emp) throws UnsupportedEncodingException, MessagingException{
		String subject = "Participation";
		String senderName = "mohameddhafer.ghedifi@esprit.tn";
		String mailContent = "<p>Cher " + emp.getFirstName() + emp.getLastName() + ",</p>";
		mailContent += "<p> you've joined a trip.congrats </p>";
		
		
		mailContent += "<p> Merci<br> </p>";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("promoesprit@gmail.com", senderName);
		helper.setTo(emp.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent, true);
		
		mailSender.send(message);
		System.out.println("email sent");
		
	}
}
