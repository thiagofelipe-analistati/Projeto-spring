package com.tfanalista.Projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfanalista.Projetospring.entidades.Categoria;
import com.tfanalista.Projetospring.repositories.CategoriaRepository;

@Service//registrando como componente do frame spring
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository userRepository;
	// metodo para buscar todos os usuários
	public List<Categoria> findAll(){
		return userRepository.findAll();

	}
	// metodo para buscar o usuário pelo id do tipo Long
	public Categoria findById(Long id) {
		
		Optional<Categoria> obj = userRepository.findById(id);
		return obj.get();
		
	}
}
