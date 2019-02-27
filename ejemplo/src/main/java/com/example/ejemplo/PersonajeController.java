package com.example.ejemplo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {
	@Autowired
	private PersonajeRepositoy repository;
	
	@RequestMapping("/personajes")
	public List<Personaje> getPersonajes(){
		return repository.findAll();
	}
	
	@RequestMapping("/personaje")
	public Personaje getPersonaje(String nombre) {
		return repository.findByNombre(nombre);
	}
	
	@RequestMapping("/nuevo")
	public void nuevoPersonaje(String nombre,String descripcion) {
		Personaje personaje=new Personaje();
		personaje.setNombre(nombre);
		personaje.setDescripcion(descripcion);
		repository.save(personaje);
	}
}
