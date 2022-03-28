package Pi.Spring.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPost;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Etat etat;
	
	private String picture;
	@NotNull
	private String content;
	


	private LocalDateTime creationDate;

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	

	public List<Emojis> getEmojis() {
		return emojis;
	}

	public void setEmojis(List<Emojis> emojis) {
		this.emojis = emojis;
	}

	public List<Commentaire> getComments() {
		return comments;
	}

	public void setComments(List<Commentaire> comments) {
		this.comments = comments;
	}


@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="EmojisPosts")
	private List<Emojis> emojis;
@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="CommentPosts")
	private List<Commentaire> comments;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="RatePost")
private List<RatingPost> ratingPost ;


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Post other = (Post) obj;
	if (content == null) {
		if (other.content != null)
			return false;
	} else if (!content.equals(other.content))
		return false;
	return true;
}




	

}
