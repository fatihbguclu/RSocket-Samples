package com.example.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
@Slf4j
public class RSocketClientConfiguration {
    @Bean
    public ApplicationRunner sender(RSocketRequester.Builder requestBuilder){
        return args -> {
            RSocketRequester tcp = requestBuilder.tcp("localhost",7000);
            String symbol = "XYZ";

            tcp.route("stock/{symbol}",symbol)
                    .retrieveFlux(StockQuote.class)
                    .doOnNext(stockQuote -> {
                        log.info("Price of {} : {} (at {}) ",
                                stockQuote.getSymbol(),
                                stockQuote.getPrice(),
                                stockQuote.getTimestamp()
                        );
                    })
                    .subscribe();
        };
    }
}
