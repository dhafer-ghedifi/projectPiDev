package tn.example.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.example.projet.model.Rating;
import tn.example.projet.service.RatingserviceImpl;


@RestController
@RequestMapping("/Rating")
public class RatingController {
	
	@Autowired
	RatingserviceImpl ratingservice;
	
	 //http://localhost:8081/Rating/retrieve_all_Ratings
	 @GetMapping("/retrieve_all_Ratings")
	    @ResponseBody
	    public List<Rating> getRatings() {
	        List<Rating> listRatings = ratingservice.retrieveAllRatings();
	        return listRatings ;
	    }
	  // http://localhost:8081/Rating/add_Rating
	    @PostMapping("/add_Rating")
	    @ResponseBody
	    public Rating addRating(@RequestBody Rating tr)
	    {
	    	Rating rating = ratingservice.addRating(tr);
	        return rating;
	    }

	 // http://localhost:8081/Rating/modify_Rating
	    @PutMapping("/modify_Rating")
	    @ResponseBody
	    public Rating modifyRating(@RequestBody Rating rating) {
	        return ratingservice.updateRating(rating);
	    }


	    // http://localhost:8081/Rating/remove_Rating/{Rating-id}
	    @DeleteMapping("/remove_rating/{rating-id}")
	    @ResponseBody
	    public void removeRating(@PathVariable("rating-id") Integer idRating) {
	    	ratingservice.deleteRating(idRating);
	    }

}
