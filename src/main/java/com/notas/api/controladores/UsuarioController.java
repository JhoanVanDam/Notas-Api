package com.notas.api.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.api.entidades.Usuario;
import com.notas.api.servicios.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioservice;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios(){
		List<Usuario> usuarios = usuarioservice.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
	return ResponseEntity.ok(usuarios);
	
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> ObtenerUsuario(@PathVariable("id")int id){
		Usuario user = usuarioservice.getUsuario(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PostMapping()
	public ResponseEntity<Usuario> SaveUser(@RequestBody Usuario user) {
		Usuario usuario = usuarioservice.SaveUsuario(user);
		
		return ResponseEntity.ok(usuario);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> DeleteUser(@PathVariable("id") int id){
		Usuario usuario = usuarioservice.getUsuario(id);
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		this.usuarioservice.deleteUsuario(id);
		return ResponseEntity.ok(usuario);
	}
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> updateUser(@PathVariable("usuarioId")int id,@RequestBody Usuario user){
		Usuario Viejo = usuarioservice.getUsuario(id);
		if (Viejo==null) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		this.usuarioservice.SaveUsuario(user);
		return ResponseEntity.ok(user);
	}
}
