package tn.example.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository <Feedback,Integer> {
	/*@Query("SELECT f FROM Feedback f WHERE f.trip_id_trip LIKE %?1%")
	 public List<Feedback> getFeedbacksByTrip(int idTrip);*/

}
