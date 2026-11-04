package com.ipartex.pruebas;

import com.ipartex.accesodatos.arrayslist.DaoMensajeArrayList;
import com.ipartex.entidades.Mensaje;

import java.util.Iterator;

import com.ipartex.accesodatos.DaoMensaje;

public class DaoMensajePruebas {
	public static void main(String[] args) {
		DaoMensaje dao = new DaoMensajeArrayList();

		for(Mensaje mensaje: dao.obtenerTodos()) {
			System.out.println(mensaje);
		}
		
		Iterable<Mensaje> i = dao.obtenerTodos();
		Iterator<Mensaje> it = i.iterator();
		
		while(it.hasNext()) {
			Mensaje mensaje = it.next();
			System.out.println(mensaje);
		}
	}
}
