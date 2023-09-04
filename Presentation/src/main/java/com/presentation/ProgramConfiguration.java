package com.presentation;

//import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;

@Configuration
@EnableJpaRepositories(basePackages = "com.data.repositories")
@EntityScan("com.data.models")
@ComponentScan("com.data.exceptions")
//@Import({org.springframework.http.HttpStatus.class})
public class ProgramConfiguration {
    /*@Bean
    public HttpStatus httpStatus() throws InstantiationException, IllegalAccessException {
        return HttpStatus.class.newInstance();
    }*/
}
