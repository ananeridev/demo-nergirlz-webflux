package com.br.demopokedexnergirlz;

import com.br.demopokedexnergirlz.document.Pokedex;
import com.br.demopokedexnergirlz.services.PokedexService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Handler {

    @Autowired
    PokedexService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Pokedex.class);
    }


    public Mono<ServerResponse> findById(ServerRequest request) {
        String Id = request.pathVariable("Id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(Id), Pokedex.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Pokedex> playlist = request.bodyToMono(Pokedex.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(service::save), Pokedex.class));
    }
}
