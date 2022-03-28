package tn.example.projet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Emojis implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idEmoji;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	
	




	public Long getIdEmoji() {
		return idEmoji;
	}







	public void setIdEmoji(Long idEmoji) {
		this.idEmoji = idEmoji;
	}







	public Type getType() {
		return type;
	}







	public void setType(Type type) {
		this.type = type;
	}







	public Post getEmojisPosts() {
		return EmojisPosts;
	}







	public void setEmojisPosts(Post emojisPosts) {
		EmojisPosts = emojisPosts;
	}







	public static long getSerialversionuid() {
		return serialVersionUID;
	}







	@ManyToOne
	Post EmojisPosts;
	
}
