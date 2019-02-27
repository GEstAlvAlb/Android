package com.example.ejemplo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonajeRepositoy extends CrudRepository<Personaje,Long>{

	List<Personaje> findAll();
	Personaje findByNombre(String nombre);
}
