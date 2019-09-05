package com.procap.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.procap.server.model.Usuario;
import com.procap.server.repo.UsuarioRepo;

import lombok.val;

@SpringBootApplication
public class ProcapServer implements CommandLineRunner {
	
	@Autowired
	UsuarioRepo usuarioRepo;

	@Override
	public void run(String... args) throws Exception {
		this.usuarioRepo.save(new Usuario(1, "Anselmo", "Ribeiro", null));
		this.usuarioRepo.save(new Usuario(2, "Marcos", "Ribeiro", null));
		this.usuarioRepo.save(new Usuario(3, "Esther Lucia", "Ribeiro", null));
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcapServer.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		val source = new UrlBasedCorsConfigurationSource();
		val config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
