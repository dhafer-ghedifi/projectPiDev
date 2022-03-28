package tn.example.projet.service;

import java.util.List;

import tn.example.projet.model.Feedback;

public interface IFeedbackservice {
	
	List<Feedback> retrieveAllFeedbacks();
    void deleteFeedback (Integer id);
    Feedback  updateFeedback(Feedback FE);
	void AddAndAffectFeedbacktrips(Feedback feed, List<Integer> idTrips, int idTrip);
	Feedback addFeedback(Feedback FE, int idTrip);
	/*public List<Feedback> ListFeedbacksByTrip(int idnr);*/

}
