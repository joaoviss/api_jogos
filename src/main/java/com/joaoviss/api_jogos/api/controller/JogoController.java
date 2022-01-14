package com.joaoviss.api_jogos.api.controller;

import java.util.List;
import com.joaoviss.api_jogos.domain.model.Jogo;
import com.joaoviss.api_jogos.domain.services.CatalogoJogoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@RestController
@RequestMapping("/jogos")
public class JogoController {
    
    private CatalogoJogoService catalogoJogoService;
    
    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo save(@RequestBody Jogo jogo) {
        return catalogoJogoService.save(jogo);
    }
    
    @CrossOrigin
    @GetMapping
    public List<Jogo> listAll() {
        return catalogoJogoService.listAll();
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> getById(@PathVariable(value = "id") Long id) {
        return catalogoJogoService.getById(id);
    }
    
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody Jogo jogo) {
        return catalogoJogoService.update(id, jogo);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        return catalogoJogoService.delete(id);
    }
}
