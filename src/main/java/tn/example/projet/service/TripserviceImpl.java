package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Trip;
import tn.example.projet.repository.TripRepository;



@Service
public class TripserviceImpl implements ITripservice{
	
	@Autowired
	TripRepository tripRepository;

	@Override
	public List<Trip> retrieveAllTrips() {
		List<Trip>Trips=new ArrayList<Trip>();
		 tripRepository.findAll().forEach(Trip -> {
			 Trips.add(Trip);
	        });
	        return Trips;
	}

	@Override
	public Trip addTrip(Trip TR) {
		
		return tripRepository.save(TR);
	}

	@Override
	public void deleteTrip(Integer id) {
		tripRepository.deleteById(id);
		
	}

	@Override
	public Trip updateTrip(Trip TR) {
		return tripRepository.save(TR);
	}
	
	@Override
	public List<Trip> getTripByDestination(String Name) {
		List<Trip>Trips=new ArrayList<>();
		 {
			tripRepository.getTripByDestination(Name).forEach(Trips::add
		        );
		}
		return Trips;
	}

	/*@Override
	public List<CountTrip> getPercentageTripByObject() {
		return tripRepository.getPercentageByObject();
	}*/
}
