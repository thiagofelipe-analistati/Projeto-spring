package com.tfanalista.Projetospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfanalista.Projetospring.entidades.Usuario;
import com.tfanalista.Projetospring.repositories.UsuarioRepository;

@Service//registrando como componente do frame spring
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository userRepository;
	// metodo para buscar todos os usuários
	public List<Usuario> findAll(){
		return userRepository.findAll();

	}
	// metodo para buscar o usuário pelo id do tipo Long
	public Usuario findById(Long id) {
		
		Optional<Usuario> obj = userRepository.findById(id);
		return obj.get();
		
	}

	public Usuario Insert(Usuario obj) {
		return userRepository.save(obj);
	}
<<<<<<< HEAD
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
=======
>>>>>>> fed37f78c12784a46f97ba3ba3052f6c4857dee4
}
