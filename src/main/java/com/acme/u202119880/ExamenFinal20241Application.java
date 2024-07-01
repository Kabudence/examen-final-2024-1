package com.acme.examenfinal20241;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ExamenFinal20241Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamenFinal20241Application.class, args);
    }

}
