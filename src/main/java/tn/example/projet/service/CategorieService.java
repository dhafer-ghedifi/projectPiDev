package tn.example.projet.service;

import java.util.List;

import tn.example.projet.model.Category;
import tn.example.projet.model.ChatRoom;


public interface CategorieService {
	List<Category> retrieveAllCategorys();
	Category addCategory(Category category);
    void deleteCategory (Long id);
    Category  updateCategory(Category category);

	void ajouterEtaffecterListechatroom(List<ChatRoom> lCR, Long idCategory);
}
