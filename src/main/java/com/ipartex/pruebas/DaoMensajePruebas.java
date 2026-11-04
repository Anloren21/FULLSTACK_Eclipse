package com.ipartex.pruebas;

import com.ipartex.accesodatos.map.DaoMensajeTreeMap;
import com.ipartex.entidades.Mensaje;

import java.time.LocalDateTime;
import java.util.Iterator;

import com.ipartex.accesodatos.DaoMensaje;

public class DaoMensajePruebas {
	public static void main(String[] args) {
		DaoMensaje dao = new DaoMensajeTreeMap();

		dao.insertar(new Mensaje(null, "Angie", "Hola a todos", LocalDateTime.now()));
		
		dao.modificar(new Mensaje(5L, "David", "Hola ya volvi", LocalDateTime.now()));

		System.out.println(dao.obtenerPorId(5L));
		System.out.println(dao.obtenerPorId(55L));
		
		for(Mensaje mensaje: dao.obtenerTodos()) {
			System.out.println(mensaje);
		}
		
//		Iterable<Mensaje> i = dao.obtenerTodos();
//		Iterator<Mensaje> it = i.iterator();
//		
//		while(it.hasNext()) {
//			Mensaje mensaje = it.next();
//			System.out.println(mensaje);
//		}
	}
}
