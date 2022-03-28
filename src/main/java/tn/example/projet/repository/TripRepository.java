package tn.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Trip;


@Repository
public interface TripRepository extends JpaRepository <Trip,Integer> {
	@Query("SELECT  tr  FROM Trip tr where tr.destination LIKE %?1%")
    public  List <Trip> getTripByDestination(  String destination);
	
	/* @Query(" select new tn.example.projet.DTO.CountTrip(COUNT(*)/(Select COUNT(*) from Trip ) * 100 , TripObject) from Trip GROUP BY TripObject")
     public  List <CountTrip> getPercentageByObject(  );*/
	
}