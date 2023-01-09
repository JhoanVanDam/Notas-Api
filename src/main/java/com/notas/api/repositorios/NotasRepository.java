package com.notas.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.api.entidades.Nota;

@Repository
public interface NotasRepository extends JpaRepository<Nota, Integer>{
	List<Nota> findByUsuarioId(int usuarioId);
	
	
	
}
