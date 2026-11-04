package com.ipartube.entidades;

public class UsuarioUsuarioPassword extends Usuario {
	// Variables de instancia
	private String usuario;
	private String password;

	// Constructores
	public UsuarioUsuarioPassword(Long id, String nombre, String usuario, String password) {
		super(id, nombre);
		setUsuario(usuario);
		setPassword(password);
	}

	public UsuarioUsuarioPassword(Long id) {
		this(id, null, null, null);
	}

	// Getter y setters

	public String getEmail() {
		return usuario;
	}

	public void setEmail(String email) {
		this.usuario = email;
	}

	private void setUsuario(String email) {
		this.usuario = email;
	}

	@Override
	public String getUsuario() {
		return usuario;
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
		return String.format("Usuario [id=%s, nombre=%s, usuario=%s, password=%s]", id, nombre, usuario, password);
	}

}
