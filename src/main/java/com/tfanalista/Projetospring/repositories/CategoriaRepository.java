package com.tfanalista.Projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfanalista.Projetospring.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
