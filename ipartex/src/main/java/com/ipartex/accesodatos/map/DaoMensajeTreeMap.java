package com.ipartex.accesodatos.map;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.TreeMap;

import com.ipartex.accesodatos.DaoMensaje;
import com.ipartex.entidades.Mensaje;

public class DaoMensajeTreeMap implements DaoMensaje {

	public DaoMensajeTreeMap() {
		insertar(new Mensaje(1L, "Angie", "Hola Mundo", LocalDateTime.now()));
		insertar(new Mensaje(2L, "Lorena", "Hola mi segundo nombre", LocalDateTime.now()));
		insertar(new Mensaje(3L, "Noa", "Hola soy la peque", LocalDateTime.now()));
		insertar(new Mensaje(4L, "Cristian", "Hola Mundo", LocalDateTime.now()));
	}

	private TreeMap<Long, Mensaje> mensajes = new TreeMap<>();

	@Override
	public Iterable<Mensaje> obtenerTodos() {
		return mensajes.values();
	}

	@Override
	public Iterable<Mensaje> obtenerParaPantalla() {
		return mensajes.values().stream().sorted((a, b) -> - a.getFechaHora().compareTo(b.getFechaHora())).toList();
	}

	@Override
	public Optional<Mensaje> obtenerPorId(Long id) {
		return Optional.ofNullable(mensajes.get(id));
	}

	@Override
	public Mensaje insertar(Mensaje mensaje) {
		Long id = mensajes.size() == 0 ? 1L : mensajes.lastKey() + 1L;

		mensaje.setId(id);

		mensajes.put(id, mensaje);

		return mensaje;
	}

	@Override
	public Mensaje modificar(Mensaje mensaje) {
		mensajes.put(mensaje.getId(), mensaje);
		return mensaje;
	}

	@Override
	public void borrar(Long id) {
		mensajes.remove(id);
	}

}
