package com.tfanalista.Projetospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfanalista.Projetospring.entidades.Usuario;
import com.tfanalista.Projetospring.service.UsuarioService;




@RestController //implementação do rest 
@RequestMapping (value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	@GetMapping
	public ResponseEntity<List<Usuario>> findall(){
		
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> FindById(@PathVariable Long id){ 
		// @PathVariable para o spring aceitar no get
		Usuario obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
