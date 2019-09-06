package com.procap.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.procap.server.model.Office;
import com.procap.server.model.Usuario;
import com.procap.server.repo.OfficeRepo;
import com.procap.server.repo.UsuarioRepo;

import lombok.val;

@SpringBootApplication
public class ProcapServer implements CommandLineRunner {

	@Autowired
	UsuarioRepo usuarioRepo;
	@Autowired
	OfficeRepo officeRepo;

	@Override
	public void run(String... args) throws Exception {
		Office office = new Office(1, "Coelho", null);
		this.officeRepo.save(office);
		this.usuarioRepo.save(new Usuario(1, "Anselmo", "Ribeiro", office));
		this.usuarioRepo.save(new Usuario(2, "Marcos", "Ribeiro", office));
		this.usuarioRepo.save(new Usuario(3, "Esther Lucia", "Ribeiro", office));
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
