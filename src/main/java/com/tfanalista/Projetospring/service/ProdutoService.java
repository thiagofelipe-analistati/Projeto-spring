package com.tfanalista.Projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfanalista.Projetospring.entidades.Produto;
import com.tfanalista.Projetospring.repositories.ProdutoRepository;

@Service//registrando como componente do frame spring
public class ProdutoService {
	
	
	@Autowired
	private ProdutoRepository userRepository;
	// metodo para buscar todos os usuários
	public List<Produto> findAll(){
		return userRepository.findAll();

	}
	// metodo para buscar o usuário pelo id do tipo Long
	public Produto findById(Long id) {
		
		Optional<Produto> obj = userRepository.findById(id);
		return obj.get();
		
	}
}
