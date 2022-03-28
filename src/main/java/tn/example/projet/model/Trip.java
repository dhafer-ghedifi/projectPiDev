package tn.example.projet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Trip implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idTrip;
	String destination;
	Integer duration;
	
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	
	@Temporal(TemporalType.DATE)
	private Date  arrivalDate;
	
	@Enumerated(EnumType.STRING)
	Object object;
	
	String description;
	private int nbIntervenant;
	 @JsonIgnore
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="trip")
		private Set<Rating> ratings;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="trip")
	private Set<Reclamation> reclamation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="trip")
	private Set<Feedback> feedback;

	
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="trips")
		private Set<Participation> participation;
	 

}
