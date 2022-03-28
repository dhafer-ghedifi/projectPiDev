package tn.example.projet.service;

import java.util.List;

import tn.example.projet.model.Reclamation;


public  interface IReclamationservice {
	List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation(Reclamation RE);
    void deleteReclamation (Integer id);
     Reclamation  updateReclamation(Reclamation RE);
}
