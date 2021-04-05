package com.tfanalista.Projetospring.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfanalista.Projetospring.entidades.Usuario;


@RestController //implementação do rest 
@RequestMapping (value = "/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findall(){
		Usuario u = new Usuario(1L,"Thiago","thiago@fel", "987526534", "123456");
				// Usuario(1L,"Thiago","thiago@fel", "987526534", "123456");
		return ResponseEntity.ok().body(u);
	}
	
}
