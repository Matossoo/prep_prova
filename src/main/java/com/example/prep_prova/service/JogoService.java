package com.example.prep_prova.service;

import com.example.prep_prova.model.Jogo;
import com.example.prep_prova.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    //salvar jogo
    public Jogo salvar(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    //listar todos
    public List<Jogo> listar(){
        return jogoRepository.findAll();
    }

    //buscar pelo id
    public Jogo buscarPorId(Long id){
        return jogoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

}
