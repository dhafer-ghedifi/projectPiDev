package tn.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Category;


@Repository
public  interface CategoryRepository extends JpaRepository <Category, Long> {
	
}

