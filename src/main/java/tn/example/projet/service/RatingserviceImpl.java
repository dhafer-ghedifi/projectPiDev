package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Rating;
import tn.example.projet.repository.RatingRepository;

@Service
public class RatingserviceImpl implements IRatingservice {

	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public List<Rating> retrieveAllRatings() {
		List<Rating>Ratings=new ArrayList<Rating>();
		 ratingRepository.findAll().forEach(Rating -> {
			 Ratings.add(Rating);
	        });
	        return Ratings;
	}

	@Override
	public Rating addRating(Rating RA) {
		 return ratingRepository.save(RA);

	}

	@Override
	public void deleteRating(Integer id) {
		ratingRepository.deleteById(id);

	}

	@Override
	public Rating updateRating(Rating RA) {
		 return ratingRepository.save(RA);

	}

	@Override
	public void assignRatingToTrip(Integer idRating, Integer idTrip) {
		// TODO Auto-generated method stub
		
	}

}
