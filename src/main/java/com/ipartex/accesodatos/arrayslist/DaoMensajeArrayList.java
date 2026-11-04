package com.ipartex.accesodatos.arrayslist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import com.ipartex.accesodatos.DaoMensaje;
import com.ipartex.entidades.Mensaje;

public class DaoMensajeArrayList implements DaoMensaje {
	private ArrayList<Mensaje> mensajes = new ArrayList<>();

	public DaoMensajeArrayList() {
		mensajes.add(new Mensaje(1L, "Angie", "Hola Mundo", LocalDateTime.now()));
		mensajes.add(new Mensaje(2L, "Lorena", "Hola mi segundo nombre", LocalDateTime.now()));
		mensajes.add(new Mensaje(3L, "Noa", "Hola soy la peque", LocalDateTime.now()));
		mensajes.add(new Mensaje(4L, "Cristian", "Hola Mundo", LocalDateTime.now()));
	}
	
	@Override
	public Iterable<Mensaje> obtenerTodos() {
		return mensajes;
	}


}
