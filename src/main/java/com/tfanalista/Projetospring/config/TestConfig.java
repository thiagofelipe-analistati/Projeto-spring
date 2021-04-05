package com.tfanalista.Projetospring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tfanalista.Projetospring.entidades.Usuario;
import com.tfanalista.Projetospring.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	// injeção de dependênica do spring
	@Autowired
	private UsuarioRepository userrepository;
	// metodo para instanciar os objetos.
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userrepository.saveAll(Arrays.asList(u1,u2));
	}
	
	

}
