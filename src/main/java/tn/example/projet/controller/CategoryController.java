package tn.example.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.example.projet.model.Category;
import tn.example.projet.model.ChatRoom;
import tn.example.projet.service.CategorieService;



@RestController
@RequestMapping("/category")
public class CategoryController {
	 @Autowired
	 CategorieService  Categorieservice; 
	//http://localhost:8081/category/add-category
	    @PostMapping("/add-category")
	    @ResponseBody
	    public Category addCategory(@RequestBody Category c)
	    {
	    	Category category = Categorieservice.addCategory(c);
	        return category;
	    }
	  //http://localhost:8081/category/retrieve-all-categorys
		 @GetMapping("/retrieve-all-categorys")
		    @ResponseBody
		    public List<Category> getCategorys() {
		        List<Category> listCategorys = Categorieservice.retrieveAllCategorys();
		        return listCategorys ;
		    }
		 
		 //http://localhost:8081/businesstravel/category/add-chatrooms/{id-category}
		 @PostMapping("/add-chatrooms/{id-category}")
		 
			public void ajouterEtaffecterListechatrooms(@RequestBody List<ChatRoom> Chatrooms, @PathVariable("id-category") Long idCategory){
			 Categorieservice.ajouterEtaffecterListechatroom(Chatrooms, idCategory);
			}
}
