package tn.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository <Feedback,Integer> {

}
