package com.joaoviss.api_jogos.controller;

import java.util.List;
import java.util.Optional;
import com.joaoviss.api_jogos.model.Jogo;
import com.joaoviss.api_jogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
public class JogoController {
    
    @Autowired
    private JogoRepository jogoRepository;
    
    @RequestMapping(value="/jogos", method = RequestMethod.GET)
    public List<Jogo> listAll() {
        return jogoRepository.findAll();
    }
    
    @RequestMapping(value = "/jogo/{id}", method = RequestMethod.GET)
    public ResponseEntity<Jogo> GetById(@PathVariable(value = "id") Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if (jogo.isPresent())
            return new ResponseEntity<Jogo>(jogo.get(), HttpStatus.OK);
            else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        @RequestMapping(value = "/jogo", method = RequestMethod.POST)
        public Jogo save(@RequestBody Jogo jogo) {
            return jogoRepository.save(jogo);
        }
        
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if (jogo.isPresent()) {
            jogoRepository.deleteById(id);
            return new ResponseEntity<String>("Jogo "+id+"deletado com sucesso!", HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
}
