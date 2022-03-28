package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.DTO.CountName;
import tn.example.projet.model.Category;
import tn.example.projet.model.ChatRoom;
import tn.example.projet.repository.chatroomrepository;
import tn.example.projet.repository.CategoryRepository;



@Service
public  class ChatRoomServiceImp implements ChatRoomService {
	@Autowired
	chatroomrepository chatRoomRepository;
	
	@Autowired
	CategoryRepository CategoryRepository ;
	
	@Override
	public List<ChatRoom> retrieveAllChatRooms() {
		 List<ChatRoom>ChatRooms=new ArrayList<ChatRoom>();
		 chatRoomRepository.findAll().forEach(ChatRoom -> {
			 ChatRooms.add(ChatRoom);
			 
	        });
		return ChatRooms;
	        
	}

	@Override
	public ChatRoom addChatRoom(ChatRoom CR) {
		 return chatRoomRepository.save(CR);
	}

	@Override
	public void deleteChatRoom(Long id) {
		ChatRoom ChatRoom = chatRoomRepository.findById(id).orElse(null);
		chatRoomRepository.delete(ChatRoom);
		
	}

	@Override
	public ChatRoom updateChatRoom(ChatRoom CR) {
		return chatRoomRepository.save(CR);
	}
	@Override
	public List<ChatRoom> getChatRoomsByCtegory(String Name) {
		List<ChatRoom>ChatRooms=new ArrayList<>();
		 {
			chatRoomRepository.getChatroomsByCategory(Name).forEach(ChatRooms::add
		        );
		}
		return ChatRooms;
	}

	
	public void affecterCRCategory(int idCR, int idCategory) {
		ChatRoom CR = chatRoomRepository.findById((long) idCR).orElse(null);
		Category category = CategoryRepository.findById((long) idCategory).orElse(null);
		category.getChatrooms().add(CR);
		CategoryRepository.save(category);
	}

	@Override
	public boolean StatusChatroom(int idCh) {
		ChatRoom chatroom = chatRoomRepository.findById( (long) idCh).orElse(null);
		if (chatroom.getSubscribers()<=chatroom.getCapacity() && chatroom.getSubscribers() >3) {
			chatroom.setIsActive(true); 
			chatRoomRepository.save(chatroom);
			
			return true; 
		}
		chatroom.setIsActive(false);
		chatRoomRepository.save(chatroom);
		return false; 
		
	}
	
	
	@Override
	public List<CountName> getPercentageChatroomByName() {
		return chatRoomRepository.getPercentageByName();
	}

	@Override
	public ChatRoom addChatRoomwithbadword(ChatRoom CR) throws tn.example.projet.service.BadWordsException  {
		// TODO Auto-generated method stub
				BadWordsService.loadConfigs();	
				//publication.setTitle4(BadWordsPublication.filterText(publication.getTitle()));
				CR.setChatRoomName(BadWordsService.filterText(CR.getChatRoomName()));

				return chatRoomRepository.save(CR);
	}
	
}
