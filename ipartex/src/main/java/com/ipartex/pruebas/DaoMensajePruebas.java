package com.ipartex.pruebas;

import com.ipartex.entidades.Mensaje;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

import java.time.LocalDateTime;

import com.ipartex.accesodatos.DaoMensaje;

public class DaoMensajePruebas {
	public static void main(String[] args) {
		DaoMensaje dao = (DaoMensaje) ContenedorInyeccionDependencias.obtenerObjeto("dao.mensaje");

		dao.insertar(new Mensaje(null, "Angie", "Hola a todos", LocalDateTime.now()));
		dao.insertar(new Mensaje(null, "Melon", "Que guay estar aquí", LocalDateTime.now()));
		

		System.out.println(dao.obtenerPorId(6L));
		System.out.println(dao.obtenerPorId(55L));

		dao.modificar(new Mensaje(5L, "David", "Hola ya volvi", LocalDateTime.now()));
		dao.borrar(5L);
		
		for(Mensaje mensaje: dao.obtenerTodos()) {
			System.out.println(mensaje);
		}
		
		for(Mensaje mensaje: dao.obtenerParaPantalla()) {
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
