package com.tech4me.tech4music.view.controller;

import java.util.List;
import java.util.Optional;

import com.tech4me.tech4music.model.Musica;
import com.tech4me.tech4music.service.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    private MusicaService serviceMusica;

    @GetMapping
    public List<Musica> obterTodos(){
        return serviceMusica.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Musica> obterPorId(@PathVariable("id") String id){
        return serviceMusica.obterPorId(id);
    }
    
    @PostMapping
    public ResponseEntity<Musica> criarMusica(@RequestBody Musica musica){
        var novoProduto = serviceMusica.criarMusica(musica);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        serviceMusica.deletar(id);
    }

    @PutMapping("/{id}")
    public Musica atualizar(@PathVariable("id") String id, @RequestBody Musica musica){
        musica.setId(id);
        return serviceMusica.atualizar(musica);
    }
}
