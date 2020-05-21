package com.br.demopokedexnergirlz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> route(Handler handler){
        return RouterFunctions
                .route(GET("/pokedex").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/pokedex/{Id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/pokedex").and(accept(MediaType.APPLICATION_JSON)), handler::save);

    }
}
