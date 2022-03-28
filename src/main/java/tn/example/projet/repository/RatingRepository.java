package tn.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Rating;


@Repository
public interface RatingRepository extends JpaRepository <Rating,Integer> {

}
