package com.example.ejemplo;

import javax.persistence.*;

@Entity
@Table(name = "personajes")
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="vida")
	private String vida;
	@Column(name="ataque")
	private String ataque;

	public Personaje() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVida() {
		return vida;
	}

	public void setVida(String vida) {
		this.vida = vida;
	}

	public String getAtaque() {
		return ataque;
	}

	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}
}
