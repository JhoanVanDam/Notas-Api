package com.notas.api.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.api.entidades.Nota;
import com.notas.api.repositorios.NotasRepository;

@Service
public class NotaService {
	@Autowired
	private NotasRepository notasRepository;
	public List<Nota> ObtenerTodas(){
		return this.notasRepository.findAll();
	}
	public Nota guardarNota(Nota nota) {
		try {

			this.notasRepository.save(nota);
			return nota;

		} catch (Exception e) {
			System.out.println("Error en NotasService / savenota" + e);
			return null;
		}

	}
	

	public Nota getNota(int id) {
		try {
			return notasRepository.findById(id).orElse(null);
		} catch (Exception e) {

			System.out.println("Error en NotasService / get nota" + e);
			return null;
		}
	}

	public void deleteNota(int id) {
		try {
			this.notasRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("Error en NotasService / del nota" + e);
		}

	}

	public Nota editarNota(Nota nota) {
		try {
			Nota buscanota = this.notasRepository.findById(nota.getId()).orElse(null);
			if (buscanota != null) {
				System.out.println("La nota ya existe");
				throw new Exception("La nota ya existe");
			}

			this.notasRepository.save(nota);
			return nota;

		} catch (Exception e) {
			System.out.println("Error en NotasService / edit nota" + e);
			return null;
		}
	}

	public List<Nota> listarNotas(int usuarioId) {
		
		return this.notasRepository.findByUsuarioId(usuarioId);
	}
	public void borrarTodo() {
		this.notasRepository.deleteAll();
	}
	
	
}
