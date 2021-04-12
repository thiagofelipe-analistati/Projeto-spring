package com.tfanalista.Projetospring.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@PostMapping
	public ResponseEntity<Usuario> Insert(@RequestBody Usuario obj){
		obj = service.Insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping (value = "/{id}")
	public ResponseEntity<Usuario> Update(@PathVariable Long id,@RequestBody  Usuario obj){
		obj = service.Update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
