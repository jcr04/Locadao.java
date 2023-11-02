package com.projetos.Locadao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocadaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadaoApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(@Value("${server.port}") int port) {
		return factory -> factory.setPort(port);
	}

}
