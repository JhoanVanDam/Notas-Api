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

import com.notas.api.entidades.Nota;
import com.notas.api.servicios.NotaService;

@RestController
@RequestMapping("/Notas")
public class NotasController {

	@Autowired
	private NotaService notasService;

	@PostMapping()
	private ResponseEntity<Nota> guardarnota(@RequestBody Nota nota) throws Exception {
		Nota notaok = this.notasService.guardarNota(nota);
		return ResponseEntity.ok(notaok);
	}

	@PutMapping("/{notaId}")
	private ResponseEntity<Nota> editarNota(@PathVariable int notaId,@RequestBody Nota nota) {
		Nota Vieja = notasService.getNota(notaId);
		if(Vieja==null) {
			return ResponseEntity.notFound().build();
		}
		
		nota.setId(notaId);
		this.notasService.guardarNota(nota);
		return ResponseEntity.ok(nota);
	}

	@DeleteMapping("/{id}")
	private void borrarNota(@PathVariable("id") int id) {
		System.out.println("Se eliminó");
		this.notasService.deleteNota(id);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Nota> obtenerNota(@PathVariable("id") int id) {
		Nota nota = this.notasService.getNota(id);
		return ResponseEntity.ok(nota);
	}

	@GetMapping()
	private List<Nota> obtenerTodasLasNotas() {
		return this.notasService.ObtenerTodas();
	}
	
	@DeleteMapping("/BORRARTODOCUIDADO")
	private String deleteTodo() {
		this.notasService.borrarTodo();
		return "Se borró todo";
	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Nota>> listaCasasPorUsuario(@PathVariable("usuarioId") int id) {
		List<Nota> notalist = notasService.listarNotas(id);
		if (notalist.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(notalist);
	}

	
}
