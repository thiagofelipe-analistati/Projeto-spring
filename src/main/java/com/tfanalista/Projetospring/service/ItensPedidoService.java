package com.tfanalista.Projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfanalista.Projetospring.entidades.ItensPedido;
import com.tfanalista.Projetospring.repositories.ItensPedidoRepository;

@Service//registrando como componente do frame spring
public class ItensPedidoService {
	
	@Autowired
	private ItensPedidoRepository userRepository;
	// metodo para buscar todos os usuários
	public List<ItensPedido> findAll(){
		return userRepository.findAll();

	}
	// metodo para buscar o usuário pelo id do tipo Long
	public ItensPedido findById(Long id) {
		
		Optional<ItensPedido> obj = userRepository.findById(id);
		return obj.get();
		
	}
}
