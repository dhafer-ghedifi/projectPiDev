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

import tn.example.projet.model.Commentaire;
import tn.example.projet.model.Emojis;
import tn.example.projet.model.Post;
import tn.example.projet.service.PostService;



@RestController
@RequestMapping("/Post")
public class PostController {
	
	@Autowired
	PostService postServ;
	
	@PostMapping("/add")
	@ResponseBody
	public String addPost(@RequestBody Post post) {
		return postServ.addPost(post);
	}
		
		@GetMapping("/CountEmojis/{id}")
		@ResponseBody
		public int nbrEmoji(@PathVariable("id") Long idPost){
			return postServ.nbrEmoji(idPost);
		}
		
		
		@GetMapping("/CountComments/{id}")
		@ResponseBody
		
		public int nbrComment(@PathVariable("id") Long idPost){
			return postServ.nbrComment(idPost);
		}
		
		
		@GetMapping("/Comments/{id}")
		@ResponseBody
		public List<Commentaire> ListComment(@PathVariable("id")Long idPost){
			return postServ.ListComment(idPost);
		}
		
		
		@GetMapping("/Emojis/{id}")
		@ResponseBody
		public List<Emojis> ListEmojis(@PathVariable("id")Long idPost){
			return postServ.ListEmojis(idPost);
		}
		
		
		@PutMapping("/update/{id}")
		@ResponseBody
		public Post updatePost(@RequestBody @PathVariable("id")Long idPost) {
			return postServ.updatePost(idPost);
		}
		
		@DeleteMapping("/delete/{id}")
		@ResponseBody
		public void deletePost(@PathVariable("id")Long idPost) {
			 postServ.deletePost(idPost);
		}
		
		@GetMapping("/retrieve")
		@ResponseBody
		public List<Post> retrieveAllPosts(Post post){
			return postServ.retrieveAllPosts(post);
		}
		
		@GetMapping("/retrieve/{id}")
		@ResponseBody
		public Post retrievePostById(@PathVariable("id")Long idPost){
			return postServ.retrievePostById(idPost);
		}
		
	

}
