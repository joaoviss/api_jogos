package com.joaoviss.api_jogos.domain.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.joaoviss.api_jogos.domain.model.Jogo;
import com.joaoviss.api_jogos.domain.repository.JogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CatalogoJogoService {
    @Autowired
    private JogoRepository jogoRepository;
    
    @Transactional
    public Jogo save(Jogo jogo) {
        return jogoRepository.save(jogo);
    }
    
    public List<Jogo> listAll() {
        return jogoRepository.findAll();
    }

    public ResponseEntity<Jogo> getById(Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return (jogo.isPresent())
            ? ResponseEntity.ok(jogo.get())
            : ResponseEntity.notFound().build();
    }

    public ResponseEntity<Jogo> update(Long id, Jogo jogo) {
        if(!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogo.setId(id);
        jogo = jogoRepository.save(jogo);
        return ResponseEntity.ok(jogo);
    }

    @Transactional
    public ResponseEntity<Void> delete(Long id) {
        if (jogoRepository.existsById(id)) {
            jogoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
