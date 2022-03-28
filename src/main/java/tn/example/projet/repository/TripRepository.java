package tn.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.example.projet.DTO.CountTrip;
import tn.example.projet.model.Trip;

@Repository
public interface TripRepository extends JpaRepository <Trip,Integer> {
	@Query("SELECT  tr  FROM Trip tr where tr.destination LIKE %?1%")
    public  List <Trip> getTripByDestination(  String destination);
	
	@Query(" select new tn.example.projet.DTO.CountTrip(COUNT(*)/(Select COUNT(*) from Trip ) * 100 , destination) from Trip GROUP BY destination")
     public  List <CountTrip> getPercentageByObject(  );
	
	@Query(value="SELECT  COUNT('employees_id_employee')  FROM participation p WHERE p.trips_id_trip=:idTrip ",nativeQuery = true)
	//nbre de participant dans un projet bien determine
		int getNbreIntervenant(@Param("idTrip") int idTrip);
	
}
