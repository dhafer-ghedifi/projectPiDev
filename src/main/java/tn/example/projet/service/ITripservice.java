package tn.example.projet.service;

import java.util.List;

import tn.example.projet.model.Trip;


public interface ITripservice {
	List<Trip> retrieveAllTrips();
	Trip addTrip(Trip TR);
    void deleteTrip (Integer id);
    Trip  updateTrip(Trip TR);
    List <Trip> getTripByDestination(  String keyword);
    /*List<CountTrip>getPercentageTripByObject();*/

}
