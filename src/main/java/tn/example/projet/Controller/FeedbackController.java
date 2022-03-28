package tn.example.projet.Controller;

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

import tn.example.projet.model.Feedback;
import tn.example.projet.service.FeedbackserviceImpl;

@RestController
@RequestMapping("/Feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackserviceImpl feedbackservice;
	
	//http://localhost:8081/Feedback/retrieve_all_Feedbacks
	 @GetMapping("/retrieve_all_Feedbacks")
	    @ResponseBody
	    public List<Feedback> getFeedbacks() {
	        List<Feedback> listFeedbacks = feedbackservice.retrieveAllFeedbacks();
	        return listFeedbacks ;
	    }

// http://localhost:8081/Feedback/add_Feedback
@PostMapping("/AddAffectFeedbackUsers/{tripsId}/{tr}")
@ResponseBody
/*public Feedback addFeedback(@RequestBody Feedback tr)
   {*/
	public void AddAffectFeedbackUsers(@RequestBody Feedback feedback,@PathVariable(name="tripsId") List<Integer> tripsId,@PathVariable(name="tr") int tr){
		feedbackservice.AddAndAffectFeedbacktrips(feedback, tripsId, tr);
   	/*Feedback Feedback = feedbackservice.addFeedback(tr);
       return Feedback;*/
   }

// http://localhost:8081/Feedback/modify_Feedback
   @PutMapping("/modify_Feedback")
   @ResponseBody
   public Feedback modifyFeedback(@RequestBody Feedback Feedback) {
       return feedbackservice.updateFeedback(Feedback);
   }


   // http://localhost:8081/Feedback/remove_Feedback/{Feedback-id}
   @DeleteMapping("/remove_Feedback/{Feedback-id}")
   @ResponseBody
   public void removeFeedback(@PathVariable("Feedback-id") Integer idFeedback) {
   	feedbackservice.deleteFeedback(idFeedback);
   }
   
  /* @GetMapping("/getFeedbackByTrip/{idTrip}")
	@ResponseBody
	public List<Feedback>getFeedbackbyTrip(@PathVariable(name="idTrip") int nr) {
	   List<Feedback>listFeedbacks= feedbackservice.ListFeedbacksByTrip(nr);
	   return listFeedbacks;
	}*/
}

