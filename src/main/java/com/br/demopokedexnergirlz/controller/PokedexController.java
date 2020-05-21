package com.br.demopokedexnergirlz.controller;

import java.time.Duration;

import com.br.demopokedexnergirlz.document.Pokedex;
import com.br.demopokedexnergirlz.services.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.util.concurrent.TimeUnit;

@RestController
public class PokedexController {


    @Autowired
    PokedexService service;


    @GetMapping(value="/pokedex")
    public Flux <Pokedex> getPokedex(){
        return service.findAll();
    }


    @GetMapping(value="/pokedex/{Id}")
    public Mono<Pokedex> getPokedexId(@PathVariable String Id) {
        return service.findById(Id);

    }


    @PostMapping(value="/pokedex")
    public Mono<Pokedex> save( @RequestBody Pokedex pokedex) {

        return service.save(pokedex);
    }

    @GetMapping(value="/pokedex/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public  Flux<Tuple2<Long, Pokedex>> getPokedexByEvents() {

        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(3));
        Flux<Pokedex> events = service.findAll();
        System.out.println("TEM UM EVENTS PASSANDO AQUIIIIIIIII");
        return Flux.zip(intervalo, events);
    }
}
