package com.ipartube.entidades;

import java.time.LocalDateTime;

public class Comentarios {
	private Long id;
	private LocalDateTime FechaHora;
	private String texto;

	private Video video;
	private Usuario usuario;

	public Comentarios(Long id, LocalDateTime fechaHora, String texto, Video video, Usuario usuario) {
		super();
		setId(id);
		setFechaHora(fechaHora);
		setTexto(texto);
		setUsuario(usuario);
		setVideo(video);
	}

	public Comentarios() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return FechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		FechaHora = fechaHora;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return String.format("Comentarios [id=%s, FechaHora=%s, texto=%s, video=%s, usuario=%s]", id, FechaHora, texto,
				video, usuario);
	}
	
	

}
