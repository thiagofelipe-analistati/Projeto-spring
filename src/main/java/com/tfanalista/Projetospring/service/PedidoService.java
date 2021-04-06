package com.tfanalista.Projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfanalista.Projetospring.entidades.Pedido;
import com.tfanalista.Projetospring.repositories.PedidoRepository;

@Service//registrando como componente do frame spring
public class PedidoService {
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	// metodo para buscar todos os pedidos
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();

	}
	// metodo para buscar os pedidos pelo id do tipo Long
	public Pedido findById(Long id) {
		
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.get();
		
	}
}
