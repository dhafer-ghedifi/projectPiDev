package Pi.Spring.Entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RatingPost implements Serializable {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idRate;
	
	public float rate;

	
	@ManyToOne
private Post RatePost;

	public Long getIdRate() {
		return idRate;
	}

	public void setIdRate(Long idRate) {
		this.idRate = idRate;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}


	public Post getRatePost() {
		return RatePost;
	}

	public void setRatePost(Post ratePost) {
		RatePost = ratePost;
	}
	

	
}
