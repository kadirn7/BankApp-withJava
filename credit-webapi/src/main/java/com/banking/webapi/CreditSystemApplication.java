package com.banking.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.banking.entities")
@EnableJpaRepositories("com.banking.repositories")
@ComponentScan(basePackages = {"com.banking.webapi", "com.banking.business"})
public class CreditSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreditSystemApplication.class, args);
    }
} 