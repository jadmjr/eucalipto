package com.eucalipto.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);		
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedHeaders("Access-Control-Allow-Origin", "*", "Access-Control-Allow-Methods",
								"POST, GET, OPTIONS, PUT, DELETE", "Access-Control-Allow-Headers",
								"Origin, X-Requested-With, Content-Type, Accept")
						.allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
