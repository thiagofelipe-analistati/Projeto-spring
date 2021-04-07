package com.tfanalista.Projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfanalista.Projetospring.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
