package tn.example.projet.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.example.projet.model.Emojis;
import tn.example.projet.model.Post;
import tn.example.projet.repository.EmojisRepository;
import tn.example.projet.repository.PostRepository;


@Service
public class EmojisServiceImpl implements EmojisService{

	
	@Autowired
	PostRepository postRepo;
	
	@Autowired 
	EmojisRepository emojiRepo;
	
	@Transactional
	@Override
	public void addAndAffectEmojis(Emojis emojis, Long idPost) {
		Post post= postRepo.findById(idPost).orElse(null);
		
		emojis.setEmojisPosts(post);
		emojiRepo.save(emojis);
		
	}

	@Override
	public void updateEmojis(Long idEmojis) {
	Emojis emojis=emojiRepo.findById(idEmojis).orElse(null);
		
		emojiRepo.save(emojis);
		
	}
}
