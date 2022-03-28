package tn.example.projet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "ChatRoom")
@Table(name = "ChatRoom")
public class ChatRoom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long  idChatRoom;
	private String ChatRoomName ;
	private Boolean isActive ;
	private Long  capacity ;
	private Long  Subscribers;
    private String Users;
  
	@ManyToOne
	@JsonIgnore
	private Category  category;
	public Long getIdChatRoom() {
		return idChatRoom;
	}
	public void setIdChatRoom(Long idChatRoom) {
		this.idChatRoom = idChatRoom;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Long getCapacity() {
		return capacity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	public Long getSubscribers() {
		return Subscribers;
	}
	public void setSubscribers(Long subscribers) {
		Subscribers = subscribers;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getChatRoomName() {
		return ChatRoomName;
	}
	public void setChatRoomName(String chatRoomName) {
		ChatRoomName = chatRoomName;
	}
	public String getUsers() {
		return Users;
	}
	public void setUsers(String username) {
		Users = username;
	}

}
