package tn.example.projet.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountName {
	private Long count ;
	private String ChatRoomName  ;
	public Long getCount() {
		return count;
	}
		
	

}