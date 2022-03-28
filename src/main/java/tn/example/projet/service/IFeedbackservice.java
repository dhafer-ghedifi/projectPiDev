package tn.example.projet.service;

import java.util.List;

import tn.example.projet.model.Feedback;


public interface IFeedbackservice {
	
	List<Feedback> retrieveAllFeedbacks();
	Feedback addFeedback(Feedback FE);
    void deleteFeedback (Integer id);
    Feedback  updateFeedback(Feedback FE);

}
