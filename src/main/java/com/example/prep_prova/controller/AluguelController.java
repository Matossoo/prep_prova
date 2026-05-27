package com.example.prep_prova.controller;

import com.example.prep_prova.model.Aluguel;
import com.example.prep_prova.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")

public class AluguelController {
    @Autowired
    private AluguelRepository repository;

    @PostMapping
    public Aluguel salvar(@RequestBody Aluguel aluguel){
        return repository.save(aluguel);
    }

    @GetMapping
    public List<Aluguel> listar(){
        return repository.findAll();
    }
}