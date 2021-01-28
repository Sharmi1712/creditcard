package com.example.creditcard.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.example.creditcard.rest.repository"})
@Configuration
public class ApplicationConfiguration {

}
