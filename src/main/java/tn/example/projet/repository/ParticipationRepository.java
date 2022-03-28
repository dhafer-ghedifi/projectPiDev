package tn.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Participation;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {

}
