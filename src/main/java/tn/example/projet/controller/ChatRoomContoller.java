package tn.example.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.example.projet.DTO.CountName;
import tn.example.projet.model.ChatRoom;
import tn.example.projet.service.BadWordsException;
import tn.example.projet.service.ChatRoomService;



@RestController
@RequestMapping("/chatroom")
public class ChatRoomContoller {
	 @Autowired
	 ChatRoomService chatroomservice; 
	 

	    //http://localhost:8081/chatroom/retrieve-all-chatrooms
	 @GetMapping("/retrieve-all-chatrooms")
	    @ResponseBody
	    public List<ChatRoom> getChatRooms() {
	        List<ChatRoom> listChatRooms = chatroomservice.retrieveAllChatRooms();
	        return listChatRooms ;
	    }
	  //http://localhost:8081/chatroom/add-Chatroom
	    @PostMapping("/add-Chatroom")
	    @ResponseBody
	    public ChatRoom addChatRoom(@RequestBody ChatRoom cr)
	    {
	    	ChatRoom chatroom = chatroomservice.addChatRoom(cr);
	        return chatroom;
	    }
	    //http://localhost:8081/chatroom/add-Chatroom_badwords
	    @PostMapping("/add-Chatroom_badwords")
	    
	    public ResponseEntity<ChatRoom> addChatRoombadwords(@RequestBody ChatRoom cr)throws BadWordsException
	    {
	        chatroomservice.addChatRoomwithbadword(cr);
	    	return new ResponseEntity(new tn.example.projet.model.Message ("chatroom created"), HttpStatus.CREATED);

	    }

	 //http://localhost:8081/chatroom/modify-chatroom
	    @PutMapping("/modify-chatroom")
	    @ResponseBody
	    public ChatRoom modifyChatRoom(@RequestBody ChatRoom chatroom) {
	        return chatroomservice.updateChatRoom(chatroom);
	    }


	    //http://localhost:8081/chatroom/remove-chatroom/{chatroom-id}
	    @DeleteMapping("/remove-chatroom/{chatroom-id}")
	    @ResponseBody
	    public void removeChatRoom(@PathVariable("chatroom-id") Long chatroomId) {
	    	chatroomservice.deleteChatRoom(chatroomId);
	    }
	    
	 // http://localhost:8081/chatroom/searchbycategory/{category}
	    @GetMapping("/searchbycategory/{category}")
	    @ResponseBody
        public List<ChatRoom> getChatRoomsbyctegory(@PathVariable("category") String keyword) {
        List<ChatRoom> listChatRooms = chatroomservice.getChatRoomsByCtegory(keyword);
         return listChatRooms ;
    
	    }
	 // http://localhost:8081/chatroom/affecter-CR-category/{idCR}/{idCategory}
	    @PutMapping("/affecter-CR-category/{idCR}/{idCategory}")
		public void affectercrca(@PathVariable("idCR") int idCR, @PathVariable("idCategory") int idCategory){
	    	chatroomservice.affecterCRCategory(idCR, idCategory);
		}
	   // http://localhost:8081/businesstravel/chatroom/isActive/{id-ch}
	   @PutMapping("/isActive/{id-ch}")
		public Boolean  getStatusChatroom(@PathVariable("id-ch") int idch){
			return chatroomservice.StatusChatroom(idch); 
		}
	   //http://localhost:8081/chatroom/getPercentage
	   @GetMapping("/getPercentage")
	    public List<CountName> getPercentage() {
	        
	        return chatroomservice.getPercentageChatroomByName();
	    }
}


