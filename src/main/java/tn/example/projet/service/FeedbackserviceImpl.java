package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Feedback;
import tn.example.projet.repository.FeedbackRepository;


@Service
public class FeedbackserviceImpl implements IFeedbackservice {
	
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> retrieveAllFeedbacks() {
		 List<Feedback>Feedbacks=new ArrayList<Feedback>();
		 feedbackRepository.findAll().forEach(Feedback -> {
			 Feedbacks.add(Feedback);
	        });
	        return Feedbacks;
	}

	@Override
	public Feedback addFeedback(Feedback FE) {
		 return feedbackRepository.save(FE);
	}

	@Override
	public void deleteFeedback(Integer id) {
		feedbackRepository.deleteById(id);
	}

	@Override
	public Feedback updateFeedback(Feedback FE) {
		return feedbackRepository.save(FE);
	}

}
