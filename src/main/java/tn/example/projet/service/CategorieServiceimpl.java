package tn.example.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Category;
import tn.example.projet.model.ChatRoom;
import tn.example.projet.repository.CategoryRepository;
import tn.example.projet.repository.chatroomrepository;



@Service
public class CategorieServiceimpl implements CategorieService {
	@Autowired
	CategoryRepository Categoryreoisitory;
	@Autowired
	chatroomrepository chatroomreoisitory;
	@Override
	public List<Category> retrieveAllCategorys() {
		 List<Category>Categorys=new ArrayList<Category>();
		 Categoryreoisitory.findAll().forEach(Category -> {
			 Categorys.add(Category);
	        });
	        return Categorys;
	}

	@Override
	public Category addCategory(Category category) {
		 return Categoryreoisitory.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterEtaffecterListechatroom(List<ChatRoom> lCR, Long idCategory) {
		Category category =  Categoryreoisitory.findById(idCategory).orElse(null);
		for (ChatRoom chatroom :lCR) {
			chatroom.setCategory(category);
			chatroomreoisitory.save(chatroom);
		}
		
	}


}

