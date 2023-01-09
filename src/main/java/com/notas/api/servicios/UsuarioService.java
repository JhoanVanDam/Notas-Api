package com.notas.api.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.api.entidades.Usuario;
import com.notas.api.repositorios.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioreposiroty;

	public List<Usuario> getAll() {
		return usuarioreposiroty.findAll();

	}

	public Usuario getUsuario(int id) {
		return usuarioreposiroty.findById(id).orElse(null);
	}

	public Usuario getNota(int id) {
		return usuarioreposiroty.findById(id).orElse(null);
	}

	public Usuario SaveUsuario(Usuario user) {
		Usuario usuario = usuarioreposiroty.save(user);
		return usuario;
	}
	public void deleteUsuario(int id) {
		 usuarioreposiroty.deleteById(id);
		
	}
	

}
