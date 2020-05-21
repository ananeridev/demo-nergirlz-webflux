package com.br.demopokedexnergirlz;

import java.util.UUID;

import com.br.demopokedexnergirlz.document.Pokedex;
import com.br.demopokedexnergirlz.repository.PokedexRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@Component
public class DummyData implements CommandLineRunner {

    private final PokedexRepository pokedexRepository;

    DummyData(PokedexRepository pokedexRepository) {
        this.pokedexRepository = pokedexRepository;
    }

    public void run(String...args) throws Exception  {
        pokedexRepository.deleteAll()
                .thenMany(
                        Flux.just("Bulbassauro", "Sharizard", "Blastoise", "Metapo")
                        .map(nome -> new Pokedex(UUID.randomUUID().toString(),nome))
                        .flatMap(pokedexRepository::save))

                .subscribe(System.out::println);
    }
}
