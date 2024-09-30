package com.example.catpurrctures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CatPurrcturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatPurrcturesApplication.class, args);
    }
}