package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args)throws Exception {
        SpringApplication.run(ClientApplication.class, args);
        Thread.sleep(12000);
    }

}