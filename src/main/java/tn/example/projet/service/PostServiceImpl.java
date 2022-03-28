package tn.example.projet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Commentaire;
import tn.example.projet.model.Emojis;
import tn.example.projet.model.Post;
import tn.example.projet.repository.CommentaireRepository;
import tn.example.projet.repository.PostRepository;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentaireRepository commentRepo;
	
	@Override
	public String addPost(Post post) {
		
		
		List<String> badwords=new ArrayList<>();
		badwords.add("bad");
		badwords.add("badwords");
		badwords.add("bads");
		String motPost[]=post.getContent().split(" ");
		String com ="";
		 
	for(String mots:motPost){

		
			if (badwords.contains(mots)){
			    mots="*****";
				com=com+" "+mots;
				return com;
			}
		else
			com=com+" "+mots;}
	 post.setContent(com);
	 post.setCreationDate(LocalDateTime.now());
	 postRepo.save(post);
	 postRepo.retrieveAllPosts(post);
	 
	 return com;
		
		
	}



	@Override
	public int nbrEmoji(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		
		return post.getEmojis().size();
	}



	@Override
	public int nbrComment(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		return post.getComments().size();
	}



	@Override
	public List<Commentaire> ListComment(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		
		return post.getComments();
	}



	@Override
	public List<Emojis> ListEmojis(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		return post.getEmojis();
	}



	@Override
	public Post updatePost(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		post.setContent(post.getContent());
		post.setEtat(post.getEtat());
		post.setCreationDate(LocalDateTime.now());
		
		 return  postRepo.save(post) ;
		
	}



	@Override
	public void deletePost(Long idPost) {
		
		postRepo.deleteById(idPost);
		
		
	}



	@Override
	public List<Post> retrieveAllPosts(Post post) {
		
		return postRepo.retrieveAllPosts(post);
	}



	@Override
	public Post retrievePostById(Long idPost) {
		
		return postRepo.findById(idPost).orElse(null);
	}

}
