package com.tfanalista.Projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfanalista.Projetospring.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
