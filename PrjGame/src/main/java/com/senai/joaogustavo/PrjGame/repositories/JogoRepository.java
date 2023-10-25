package com.senai.joaogustavo.PrjGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.joaogustavo.PrjGame.entities.Jogos;

public interface JogoRepository extends JpaRepository<Jogos, Long>{

}
