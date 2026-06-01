package com.example.prep_prova.service;

import com.example.prep_prova.model.Aluguel;
import com.example.prep_prova.model.Jogo;
import com.example.prep_prova.repository.AluguelRepository;
import com.example.prep_prova.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public Aluguel salvar(Aluguel aluguel){
        Long idJogo = aluguel.getJogo().getId();

        Jogo jogoEncontrado = jogoRepository.findById(idJogo)
                .orElseThrow(()-> new RuntimeException("jogo não encontrado"));

        if(aluguel.getQuantidade() > jogoEncontrado.getQuantidade()){
            throw new RuntimeException("Quantidade indisponivel");
        }
        //atualiza a quantiadade disponivel
        jogoEncontrado.setQuantidade(
                jogoEncontrado.getQuantidade() - aluguel.getQuantidade()
        );
        //relaciona o jogo ao aluguel
        aluguel.setJogo(jogoEncontrado);

        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listar(){
        return aluguelRepository.findAll();
    }
}