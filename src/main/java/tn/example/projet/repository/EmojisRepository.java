package tn.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmojisRepository extends JpaRepository<tn.example.projet.model.Emojis, Long> {

}
