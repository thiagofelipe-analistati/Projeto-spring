package com.tfanalista.Projetospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfanalista.Projetospring.entidades.Produto;
import com.tfanalista.Projetospring.service.ProdutoService;




@RestController //implementação do rest 
@RequestMapping (value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	@GetMapping
	public ResponseEntity<List<Produto>> findall(){
		
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> FindById(@PathVariable Long id){ 
		// @PathVariable para o spring aceitar no get
		Produto obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
