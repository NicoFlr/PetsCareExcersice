package com.presentation;

import org.hibernate.annotations.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;

@SpringBootApplication(scanBasePackages = {"com.data","com.presentation","com.services"})

/*@TypeHints({
        @TypeHint(types = HttpStatus.class)
})*/
public class Program {

    public static void main(String[] args) {
        //ApplicationContext appContext = new AnnotationConfigApplicationContext(ProgramConfiguration.class);
        //appContext.getBean()
        SpringApplication.run(Program.class, args);
    }

}