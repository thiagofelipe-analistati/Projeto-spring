package com.tfanalista.Projetospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfanalista.Projetospring.entidades.ItensPedido;
import com.tfanalista.Projetospring.service.ItensPedidoService;




@RestController //implementação do rest 
@RequestMapping (value = "/itenspedido")
public class ItensPedidoResource {
	
	@Autowired
	private ItensPedidoService service;
	@GetMapping
	public ResponseEntity<List<ItensPedido>> findall(){
		
		List<ItensPedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItensPedido> FindById(@PathVariable Long id){ 
		// @PathVariable para o spring aceitar no get
		ItensPedido obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
