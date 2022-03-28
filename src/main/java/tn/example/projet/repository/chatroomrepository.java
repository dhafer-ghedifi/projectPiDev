package tn.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.example.projet.DTO.CountName;
import tn.example.projet.model.ChatRoom;



@Repository
public interface chatroomrepository extends JpaRepository <ChatRoom, Long> {
	 @Query("SELECT  cr   FROM ChatRoom cr where cr.category.Name LIKE %?1%")
     public  List <ChatRoom> getChatroomsByCategory(  String Name);
	 @Query(" select new tn.example.projet.DTO.CountName(COUNT(*)/(Select COUNT(*) from ChatRoom ) * 100 , ChatRoomName) from ChatRoom GROUP BY ChatRoomName")
     public  List <CountName> getPercentageByName(  );
	
}