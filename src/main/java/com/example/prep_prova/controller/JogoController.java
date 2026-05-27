package com.example.prep_prova.controller;

import com.example.prep_prova.model.Jogo;
import com.example.prep_prova.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")

public class JogoController {
    //Anotação para que vai instruir o Spring a procurar uma instancia pronta
    @Autowired
    private JogoRepository repository;

    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo){
        return repository.save(jogo);
    }

    @GetMapping
    public List<Jogo> listar(){
        return repository.findAll();
    }
}

