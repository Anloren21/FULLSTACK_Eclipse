package com.ipartube.entidades;

public abstract class Usuario {
	// Variables de instancia
	protected Long id;
	protected String nombre;

	// Constructores
	public Usuario(Long id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	public Usuario (Long id) {
		this(id, null);
	}

	// Getter y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String getUsuario();
	public abstract String getPassword();

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, nombre=%s]", id, nombre);
	}

	
	
}
