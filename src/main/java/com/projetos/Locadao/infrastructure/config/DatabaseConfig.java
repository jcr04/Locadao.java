package com.projetos.Locadao.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.projetos.Locadao.infrastructure.persistence.repository")
public class DatabaseConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
