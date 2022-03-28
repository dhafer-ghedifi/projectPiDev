package tn.example.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.example.projet.model.Reclamation;
import tn.example.projet.service.ReclamationserviceImpl;



@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {
	
	@Autowired
	ReclamationserviceImpl Reclamationservice;
	
	
	//http://localhost:8081/Reclamation/retrieve_all_Reclamations
		 @GetMapping("/retrieve_all_Reclamations")
		    @ResponseBody
		    public List<Reclamation> getReclamations() {
		        List<Reclamation> listReclamations = Reclamationservice.retrieveAllReclamations();
		        return listReclamations ;
		    }
	
	 // http://localhost:8081/Reclamation/add_Reclamation
	 @PostMapping("/add_Reclamation")
	 @ResponseBody
	 public Reclamation addReclamation(@RequestBody Reclamation tr)
	    {
	    	Reclamation Reclamation = Reclamationservice.addReclamation(tr);
	        return Reclamation;
	    }
	 
	// http://localhost:8081/Reclamation/modify_Reclamation
	    @PutMapping("/modify_Reclamation")
	    @ResponseBody
	    public Reclamation modifyReclamation(@RequestBody Reclamation Reclamation) {
	        return Reclamationservice.updateReclamation(Reclamation);
	    }


	    // http://localhost:8081/Reclamation/remove_Reclamation/{Reclamation-id}
	    @DeleteMapping("/remove_Reclamation/{Reclamation-id}")
	    @ResponseBody
	    public void removeReclamation(@PathVariable("Reclamation-id") Integer idReclamation) {
	    	Reclamationservice.deleteReclamation(idReclamation);
	    }
}

