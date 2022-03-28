package tn.example.projet.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountTrip {
	
	private Long count ;
	private String destination  ;
	public Long getCount() {
		return count;
	}
		

}
