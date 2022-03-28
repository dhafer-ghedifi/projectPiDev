
package tn.example.projet.Controller;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.example.projet.DTO.CountTrip;
import tn.example.projet.model.Employee;
import tn.example.projet.model.Trip;
import tn.example.projet.service.TripserviceImpl;

import antlr.CodeGenerator;


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
		    
		    
		 //http://localhost:8081/trip/getPercentage
			   @GetMapping("/getPercentage")
			    public List<CountTrip> getPercentageTripByObject() {
			        
			        return tripservice.getPercentageTripByObject();
			    }
		    
		 // http://localhost:8081/trip/add_trip	
			@PostMapping("/add-participation/{tripId}/{employeeId}")
			public void addPartcipation(@PathVariable("tripId") int tripId,@PathVariable("employeeId") int employeeId) throws Exception {
				 tripservice.addParticipation(tripId, employeeId);
			}
			
			@GetMapping("/retrieve-employeeaffectedbyentreprise/{entrepriseId}")
			public List<Employee> findEmployeeAffectedToVoyageByEntrepriseId(@PathVariable("entrepriseId") int entrepriseId ){
				return tripservice.findEmployeeAffectedToVoyageByEntrepriseId(entrepriseId);
			}
			@PostMapping("/add-rating/{tripId}/{employeeId}/{quality_of_our_service}")
			public void addRating(@PathVariable("tripId") int tripId,@PathVariable("employeeId") int employeeId,@PathVariable("quality_of_our_service") float quality_of_our_service )  {
				 tripservice.voterTrip(tripId, employeeId, quality_of_our_service);
			}
			@GetMapping("/getMoyenneNote/{tripId}")
			public Float getMoyenne(@PathVariable("tripId") int tripId ){
				return tripservice.getMoyenneVote(tripId);
			}
			@GetMapping(value = "/zxing/qrcode/{tripId}")
		    public ResponseEntity<BufferedImage> zxingQRCode(@PathVariable("tripId") int tripId) throws Exception{
		        return successResponse(tripservice.generateQRCode(tripId+""));
		    }

		    private ResponseEntity<BufferedImage> successResponse(BufferedImage image) {
		        return new ResponseEntity<>(image, HttpStatus.OK);
		    }
		    
		    
}
