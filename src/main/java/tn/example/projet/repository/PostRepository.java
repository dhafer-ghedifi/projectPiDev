package tn.example.projet.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Post;



@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	
	@Query("SELECT p FROM Post p ")
	@Transactional
	public List<Post> retrieveAllPosts(Post post);

}
