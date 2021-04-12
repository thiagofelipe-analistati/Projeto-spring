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

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	public Usuario Update(Long id, Usuario obj) {
		Usuario entidade = userRepository.getOne(id);
		UpdateData(entidade, obj);
		return userRepository.save(entidade);
	}
	private void UpdateData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
			
}
