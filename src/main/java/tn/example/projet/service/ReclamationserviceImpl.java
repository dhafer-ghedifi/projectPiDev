package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Reclamation;
import tn.example.projet.repository.ReclamationRepository;


@Service 
public class ReclamationserviceImpl implements IReclamationservice {
	@Autowired
	ReclamationRepository reclamationRepository;
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation>Reclamations=new ArrayList<Reclamation>();
		 reclamationRepository.findAll().forEach(Reclamation -> {
			 Reclamations.add(Reclamation);
	        });
	        return Reclamations;
	}

	@Override
	public Reclamation addReclamation(Reclamation RE) {
		 return reclamationRepository.save(RE);
	}

	@Override
	public void deleteReclamation(Integer id) {
		reclamationRepository.deleteById(id);		
	}

	@Override
	public Reclamation updateReclamation(Reclamation RE) {
		return reclamationRepository.save(RE);

	}

}
