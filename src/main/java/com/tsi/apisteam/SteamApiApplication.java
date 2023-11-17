package com.tsi.apisteam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SteamApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SteamApiApplication.class, args);
        System.out.println("Esta rodando");
    }
}
