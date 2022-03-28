package tn.example.projet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Commentaire;


@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long> {

}
