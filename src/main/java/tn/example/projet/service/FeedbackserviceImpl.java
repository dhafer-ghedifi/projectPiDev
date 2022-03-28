package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Feedback;
import tn.example.projet.model.Trip;
import tn.example.projet.repository.FeedbackRepository;
import tn.example.projet.repository.TripRepository;

@Service
public class FeedbackserviceImpl implements IFeedbackservice {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	TripRepository triprepository;

	@Override
	public List<Feedback> retrieveAllFeedbacks() {
		 List<Feedback>Feedbacks=new ArrayList<Feedback>();
		 feedbackRepository.findAll().forEach(Feedback -> {
			 Feedbacks.add(Feedback);
	        });
	        return Feedbacks;
	}

	@Override
	public Feedback addFeedback(Feedback FE, int idTrip) {
		Trip tr=triprepository.findById(idTrip).orElse(null);
		FE.setTrip(tr);
		 return feedbackRepository.save(FE);
	}
	
	@Override
	@Transactional
	public void AddAndAffectFeedbacktrips(Feedback feed , List<Integer> idTrips, int idTr) {
		Feedback f =addFeedback(feed, idTr);
		for (int idTrip : idTrips) {
			Trip tr = triprepository.findById(idTrip).orElse(null);
			tr.getFeedback().add(f);
			triprepository.save(tr);
		}
		
	}

	@Override
	public void deleteFeedback(Integer id) {
		feedbackRepository.deleteById(id);
	}

	@Override
	public Feedback updateFeedback(Feedback FE) {
		return feedbackRepository.save(FE);
	}
	
	
	/*@Override
	public List<Feedback> ListFeedbacksByTrip(int idnr) {
		List<Feedback>Feedbacks=new ArrayList<>();
		 {
		feedbackRepository.getFeedbacksByTrip(idnr).forEach(Feedbacks::add);
	}
		 return Feedbacks;
	}*/

}
