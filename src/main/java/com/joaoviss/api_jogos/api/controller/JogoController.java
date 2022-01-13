package com.joaoviss.api_jogos.api.controller;

import java.util.List;

import com.joaoviss.api_jogos.domain.model.Jogo;
import com.joaoviss.api_jogos.domain.repository.JogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin
@RestController
@RequestMapping("/jogos")
public class JogoController {
    
    @Autowired
    private JogoRepository jogoRepository;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo save(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }
        
    @GetMapping
    public List<Jogo> listAll() {
        return jogoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> getById(@PathVariable(value = "id") Long id) {
        return jogoRepository.findById(id)
            .map (jogo -> ResponseEntity.ok(jogo))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody Jogo jogo) {
        if(!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogo.setId(id);
        jogo = jogoRepository.save(jogo);
        return ResponseEntity.ok(jogo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        if(!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
