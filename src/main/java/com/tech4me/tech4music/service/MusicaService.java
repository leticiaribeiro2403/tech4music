package com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.tech4music.model.Musica;
import com.tech4me.tech4music.repository.MusicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {
    
    @Autowired
    private MusicaRepository repositoryMusica;
    
    public List<Musica> obterTodos(){
        return repositoryMusica.findAll();
    }

      public Optional<Musica> obterPorId(String id){
        return repositoryMusica.findById(id);
    }

    public Musica criarMusica(Musica musica){
        musica.setId(null);
        return repositoryMusica.save(musica);
    }

    public void deletar(String id){
        repositoryMusica.deleteById(id);
    }

    public Musica atualizar(Musica musica){
        return repositoryMusica.save(musica);
    }
}
