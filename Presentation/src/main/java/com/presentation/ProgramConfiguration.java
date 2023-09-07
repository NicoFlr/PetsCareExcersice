package com.presentation;

import com.data.models.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableJpaRepositories(basePackages = "com.data.repositories")
@EntityScan("com.data.models")
@ComponentScan("com.data.exceptions")
//@Import({org.springframework.http.HttpStatus.class})
public class ProgramConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Breed.class, Owner.class, Pet.class, Petcardex.class, Species.class);

    }
}
