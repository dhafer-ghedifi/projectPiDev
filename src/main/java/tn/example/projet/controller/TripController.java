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

import tn.example.projet.model.Trip;
import tn.example.projet.service.TripserviceImpl;



@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	TripserviceImpl tripservice;
	
	//http://localhost:8081/trip/retrieve_all_trips
		 @GetMapping("/retrieve_all_trips")
		    @ResponseBody
		    public List<Trip> getTrips() {
		        List<Trip> listTrips = tripservice.retrieveAllTrips();
		        return listTrips ;
		    }
		  // http://localhost:8081/trip/add_trip
		    @PostMapping("/add_trip")
		    @ResponseBody
		    public Trip addTrip(@RequestBody Trip tr)
		    {
		    	Trip trip = tripservice.addTrip(tr);
		        return trip;
		    }

		 // http://localhost:8081/trip/modify_trip
		    @PutMapping("/modify_trip")
		    @ResponseBody
		    public Trip modifyTrip(@RequestBody Trip trip) {
		        return tripservice.updateTrip(trip);
		    }


		    // http://localhost:8081/trip/remove_trip/{trip-id}
		    @DeleteMapping("/remove_trip/{trip-id}")
		    @ResponseBody
		    public void removeTrip(@PathVariable("trip-id") Integer idTrip) {
		    	tripservice.deleteTrip(idTrip);
		    }

		    
		    
		 // http://localhost:8081/trip/searchbydestination/{destination}
		    @GetMapping("/searchbydestination/{destination}")
		    @ResponseBody
	        public List<Trip> getTripByDestination(@PathVariable("destination") String keyword) {
	        List<Trip> listTrips = tripservice.getTripByDestination(keyword);
	         return listTrips ;
	    
	

		    }
		    
		    
		 /* //http://localhost:8081/trip/getPercentage
			   @GetMapping("/getPercentage")
			    public List<CountTrip> getPercentageTripByObject() {
			        
			        return tripservice.getPercentageTripByObject();
			    }*/
}

