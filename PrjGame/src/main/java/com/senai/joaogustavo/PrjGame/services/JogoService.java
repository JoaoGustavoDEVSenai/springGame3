package com.senai.joaogustavo.PrjGame.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.joaogustavo.PrjGame.entities.Jogos;
import com.senai.joaogustavo.PrjGame.repositories.JogoRepository;

@Service
public class JogoService {
	
	private final JogoRepository jogoRepository;
	
	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogos getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public List<Jogos> getAllJogo(){
		return jogoRepository.findAll();
	}
	
	public Jogos saveJogo(Jogos jogo) {
		return jogoRepository.save(jogo);
	}
	
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
	
	public Jogos updateJogo(Long id, Jogos novoJogo) {
		Optional<Jogos> jogoOptional = jogoRepository.findById(id);
		
		if(jogoOptional.isPresent() ) {
			Jogos jogoExistente = jogoOptional.get();
			jogoExistente.setName(novoJogo.getName() );
			jogoExistente.setPlataform(novoJogo.getPlataform() );
			return jogoRepository.save(jogoExistente);
		} else {
			return null;
		}
	}
}