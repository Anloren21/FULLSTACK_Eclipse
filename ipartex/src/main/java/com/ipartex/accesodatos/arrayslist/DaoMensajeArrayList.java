package com.ipartex.accesodatos.arrayslist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import com.ipartex.accesodatos.DaoMensaje;
import com.ipartex.entidades.Mensaje;

import bibliotecas.accesodatos.AccesoDatosException;

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
	
	@Override
	public Optional<Mensaje> obtenerPorId(Long id) {
		for(Mensaje m: mensajes) {
			if(id == m.getId()) {
				return Optional.of(m);
			}
		}
		return Optional.empty();
	}

	@Override
	public Mensaje insertar(Mensaje mensaje) {
		Long id = 0L ;
		
		for(Mensaje m: mensajes) {
			id = m.getId() > id ? m.getId(): id;
		}
		
		mensaje.setId(id + 1);
		mensajes.add(mensaje);
		
		return mensaje;
	}

	@Override
	public Mensaje modificar(Mensaje mensajeModificado) {
		for(Mensaje mensajeOriginal: mensajes) {
			if(mensajeOriginal.getId() == mensajeModificado.getId()) {
				mensajes.set(mensajes.indexOf(mensajeOriginal), mensajeModificado);
				return mensajeModificado;
			}
		}
		
		throw new AccesoDatosException("No se ha encontrado el registro a modificar");
	}

	@Override
	public void borrar(Long id) {
		for(Mensaje mensajeOriginal: mensajes) {
			if(mensajeOriginal.getId() == id) {
				mensajes.remove(mensajeOriginal);
				return;
			}
		}
		
		throw new AccesoDatosException("No se ha borrado el mensaje");
	}
	
}
