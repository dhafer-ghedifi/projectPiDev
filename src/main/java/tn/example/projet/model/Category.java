package tn.example.projet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long  idCategory;

@Column(name="Name")
public String Name ;
@Column(name="Description")
public String Description;

@OneToMany(mappedBy="category",cascade={CascadeType.PERSIST, CascadeType.REMOVE},
fetch=FetchType.EAGER)
@JsonIgnore
private Set<ChatRoom> Chatrooms;
public Long getIdCategory() {
	return idCategory;
}
public void setIdCategory(Long idCategory) {
	this.idCategory = idCategory;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public Set<ChatRoom> getChatrooms() {
	return Chatrooms;
}
public void setChatrooms(Set<ChatRoom> chatrooms) {
	Chatrooms = chatrooms;
}

}

