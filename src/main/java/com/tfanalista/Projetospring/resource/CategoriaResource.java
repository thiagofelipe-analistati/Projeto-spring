package com.tfanalista.Projetospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfanalista.Projetospring.entidades.Categoria;
import com.tfanalista.Projetospring.service.CategoriaService;




@RestController //implementação do rest 
@RequestMapping (value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	@GetMapping
	public ResponseEntity<List<Categoria>> findall(){
		
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> FindById(@PathVariable Long id){ 
		// @PathVariable para o spring aceitar no get
		Categoria obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
