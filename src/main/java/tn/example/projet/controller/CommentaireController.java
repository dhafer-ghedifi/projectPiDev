package tn.example.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.example.projet.model.Commentaire;
import tn.example.projet.service.CommentaireService;



@RestController
@RequestMapping("/Comment")
public class CommentaireController {
	@Autowired
	CommentaireService commentService;
	
	
	
	@PostMapping("/add/{idPost}")
	@ResponseBody
	public String addAndAffectComment(@RequestBody Commentaire comment,@PathVariable("idPost")Long idPost){
		return commentService.addAndAffectComment(comment, idPost);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public Commentaire updateComment(@RequestBody @PathVariable("id")Long idComment) {
		return commentService.updateComment(idComment);
	}
	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public Commentaire retrieveCommentById(@PathVariable("id")Long idComment){
		return commentService.retrieveCommentById(idComment);
	}

}
