package com.ipartube.entidades;

public class UsuarioEmailPassword extends Usuario {
	// Variables de instancia
	private String email;
	private String password;

	// Constructores
	public UsuarioEmailPassword(Long id, String nombre, String email, String password) {
		super(id, nombre);
		setEmail(email);
		setPassword(password);
	}

	public UsuarioEmailPassword(Long id) {
		this(id, null, null, null);
	}

	// Getter y setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getUsuario() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, nombre=%s, email=%s, password=%s]", id, nombre, email, password);
	}

}
