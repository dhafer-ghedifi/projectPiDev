package tn.example.projet.service;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import tn.example.projet.DTO.CountTrip;
import tn.example.projet.model.Employee;
import tn.example.projet.model.Participation;
import tn.example.projet.model.Trip;


public interface ITripservice {
	List<Trip> retrieveAllTrips();
	Trip addTrip(Trip TR);
    void deleteTrip (Integer id);
    Trip  updateTrip(Trip TR);
    List <Trip> getTripByDestination(  String keyword);
    List<CountTrip>getPercentageTripByObject();
    
	Participation addParticipation(int tripId, int employeeId) throws Exception;

	public  BufferedImage generateQRCode(String urlText) throws Exception;
	public void sendEmail (Employee emp) throws UnsupportedEncodingException, MessagingException;


	List<Employee> findEmployeeAffectedToVoyageByEntrepriseId(int entrepriseId);
	void updateNbreIntervenant();
	void voterTrip(int tripId,int employeId,float quality_of_our_service);
	Float getMoyenneVote(int tripId);
	List<Participation> RetrieveAllParticipationss();

}
