package tn.example.projet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Commentaire;
import tn.example.projet.model.Post;
import tn.example.projet.repository.CommentaireRepository;
import tn.example.projet.repository.PostRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	CommentaireRepository commentRepo;

	@Override
	public String addAndAffectComment(Commentaire comment, Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		List<String> badwords=new ArrayList<>();
		badwords.add("badbad");
		badwords.add("badwords");
		badwords.add("bads");
		
		String motcommentaire[]=comment.getContent().split(" ");
		String com ="";
		for(String mots:motcommentaire){

			
			if (badwords.contains(mots)){
			    mots="*****";
				com=com+" "+mots;	
				return com;
			}
		else
			com=com+" "+mots;}
		comment.setContent(com);
		comment.setCommentPosts(post);
		comment.setCreationDateComment(LocalDateTime.now());
		commentRepo.save(comment);
		return com;
		}

	@Override
	public void deleteComment(Long idPost) {
		commentRepo.deleteById(idPost);
		
	}

	@Override
	public Commentaire updateComment(Long idPost) {
		Commentaire comment=commentRepo.findById(idPost).orElse(null);
		return commentRepo.save(comment);
	}

	@Override
	public Commentaire retrieveCommentById(Long idComment) {
		
		return commentRepo.findById(idComment).orElse(null);
	}


}
