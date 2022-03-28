package tn.example.projet.service;

import java.util.List;

import tn.example.projet.DTO.CountName;
import tn.example.projet.model.ChatRoom;


public interface ChatRoomService {
	List<ChatRoom> retrieveAllChatRooms();
	ChatRoom addChatRoom(ChatRoom CR);
    void deleteChatRoom (Long id);
    ChatRoom  updateChatRoom(ChatRoom CR);
    List<ChatRoom> getChatRoomsByCtegory( String keyword);
    boolean StatusChatroom(int idCh);
    void affecterCRCategory(int idCR, int idCategory);
	List<CountName>getPercentageChatroomByName();
	ChatRoom addChatRoomwithbadword(ChatRoom CR) throws tn.example.projet.service.BadWordsException ;
}