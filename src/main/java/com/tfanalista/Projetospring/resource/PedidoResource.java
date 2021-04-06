package com.tfanalista.Projetospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfanalista.Projetospring.entidades.Pedido;
import com.tfanalista.Projetospring.service.PedidoService;




@RestController //implementação do rest 
@RequestMapping (value = "/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	@GetMapping
	public ResponseEntity<List<Pedido>> findall(){
		
		List<Pedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> FindById(@PathVariable Long id){ 
		// @PathVariable para o spring aceitar no get
		Pedido obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
