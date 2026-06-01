package com.example.prep_prova.controller;

import com.example.prep_prova.model.Aluguel;
import com.example.prep_prova.repository.AluguelRepository;
import com.example.prep_prova.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")

public class AluguelController {

    @Autowired
    private AluguelService service;

    @PostMapping
    public Aluguel salvar(@RequestBody Aluguel aluguel){
        return service.salvar(aluguel);
    }

    @GetMapping
    public List<Aluguel> listar(){
        return service.listar();
    }
}