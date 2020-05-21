package com.br.demopokedexnergirlz.services;

import com.br.demopokedexnergirlz.document.Pokedex;
import com.br.demopokedexnergirlz.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokedexServiceImpl implements PokedexService{

    @Autowired
    PokedexRepository pr;

    @Override
    public Flux<Pokedex> findAll() {
        return pr.findAll();
    }

    @Override
    public Mono<Pokedex> findById(String id) {
        return pr.findById(id);
    }

    public Mono<Pokedex> save(Pokedex pokedex) {
        return pr.save(pokedex);
    }
}
