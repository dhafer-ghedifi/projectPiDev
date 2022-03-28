package tn.example.projet.service;

import java.util.List;

import tn.example.projet.model.Rating;


public interface IRatingservice {
	List<Rating> retrieveAllRatings();
	Rating addRating(Rating RA);
    void deleteRating (Integer id);
    Rating  updateRating(Rating RA);
	void assignRatingToTrip(Integer idRating,Integer idTrip);

}
