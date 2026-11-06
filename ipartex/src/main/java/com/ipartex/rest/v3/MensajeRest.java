package com.ipartex.rest.v3;


import com.ipartex.entidades.Mensaje;
import com.ipartex.logicanegocio.AnonimoNegocio;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mensajes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensajeRest {
	
	private static final AnonimoNegocio NEGOCIO = (AnonimoNegocio) ContenedorInyeccionDependencias.obtenerObjeto("negocio.anonimo");
	
	@GET
	public Iterable<Mensaje> getMensaje(){
		return NEGOCIO.listarMensajes();
	}
}
