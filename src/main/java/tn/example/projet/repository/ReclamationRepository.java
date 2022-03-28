package tn.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Reclamation;


@Repository
public interface ReclamationRepository extends JpaRepository <Reclamation,Integer> {

}
