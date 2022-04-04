package com.example.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class GreetingController {

    @MessageMapping("greeting")
    public Mono<String> handle(Mono<String> greetingMono){

        return greetingMono.doOnNext(greeting ->
                    log.info("Received a greeting : {}",greeting)
                ).map(greeting -> "Hello Back To You");

    }

    @MessageMapping("greeting/{name}")
    public Mono<String> handle(@DestinationVariable("name") String name, Mono<String> greetingMono){
        return greetingMono.doOnNext(greeting -> {
                    log.info("Received a greeting from {} : {}", name, greeting);
                })
                .map(greeting -> "Hello to You,  to" + name);
    }


}
