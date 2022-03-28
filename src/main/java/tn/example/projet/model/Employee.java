package tn.example.projet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	
	@NonNull private String FirstName, LastName;
	private String  email;

	@ToString.Exclude
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
	private Set<Participation> participation;
 
	@JsonIgnore
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="employee")
		private Set<Rating> ratings;
	
	@ManyToOne
	private Entreprise entreprises;
}
