package com.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.data","com.presentation","com.services"})

public class Program {

    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }
}