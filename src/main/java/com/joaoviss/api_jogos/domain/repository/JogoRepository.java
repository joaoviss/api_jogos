package com.joaoviss.api_jogos.domain.repository;

import com.joaoviss.api_jogos.domain.model.Jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {}