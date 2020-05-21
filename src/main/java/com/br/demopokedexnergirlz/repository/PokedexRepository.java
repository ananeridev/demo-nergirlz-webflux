package com.br.demopokedexnergirlz.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.br.demopokedexnergirlz.document.Pokedex;


// essa classe nos permite ter acesso aos métodos prontos do mongodb
public interface PokedexRepository extends ReactiveMongoRepository<Pokedex, String> {
}
