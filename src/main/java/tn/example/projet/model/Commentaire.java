package tn.example.projet.model;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idComment;
	
	@NotNull
	private String content;
	
	private LocalDateTime creationDateComment;

	



	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Post getCommentPosts() {
		return CommentPosts;
	}


	public void setCommentPosts(Post commentPosts) {
		CommentPosts = commentPosts;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	public LocalDateTime getCreationDateComment() {
		return creationDateComment;
	}

	public void setCreationDateComment(LocalDateTime creationDateComment) {
		this.creationDateComment = creationDateComment;
	}




	public Long getIdComment() {
		return idComment;
	}


	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}



	@JsonIgnore
	@ManyToOne
	Post CommentPosts;

}
