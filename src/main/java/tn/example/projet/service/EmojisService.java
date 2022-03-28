package tn.example.projet.service;

import tn.example.projet.model.Emojis;

public interface EmojisService {
	public void updateEmojis(Long idEmojis);
	public void addAndAffectEmojis(Emojis emojis, Long idPost);

}
