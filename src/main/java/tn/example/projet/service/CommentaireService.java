package tn.example.projet.service;

import tn.example.projet.model.Commentaire;

public interface CommentaireService {
	public String addAndAffectComment(Commentaire comment, Long idPost);
	public void deleteComment(Long idPost);
	public Commentaire updateComment(Long idPost);
	public Commentaire retrieveCommentById(Long idComment);
}
