package com.tfanalista.Projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tfanalista.Projetospring.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
