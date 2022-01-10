package com.joaoviss.api_jogos.repository;

import com.joaoviss.api_jogos.model.Jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {}
