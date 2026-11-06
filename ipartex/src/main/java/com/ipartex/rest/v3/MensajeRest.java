
package com.ipartex.rest.v3;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import com.ipartex.entidades.Mensaje;
import com.ipartex.logicanegocio.AnonimoNegocio;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.MediaType;

@Path("/mensajes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensajeRest {

	private static final AnonimoNegocio NEGOCIO = (AnonimoNegocio) ContenedorInyeccionDependencias
			.obtenerObjeto("negocio.anonimo");

	@GET
	public Iterable<Mensaje> getMensajes() {
		return NEGOCIO.listarMensajes();
	}

	@GET
	@Path("{id}")
	public Mensaje getMensajePorId(@PathParam("id") Long id) {

		return NEGOCIO.buscarMensajePorId(id)
				.orElseThrow(() -> new NotFoundException("Mensaje con id=" + id + " no encontrado"));
	}

	@GET
	@Path("buscar")
	public Iterable<Mensaje> buscarMensajes(@QueryParam("fecha-minima") String fechaMinima) {

		if (fechaMinima == null || fechaMinima.isBlank()) {
			throw new BadRequestException("Debes indicar una fecha mínima");
		}

		try {
			LocalDateTime fecha = LocalDateTime.parse(fechaMinima);

			return NEGOCIO.buscarMensajesPorFechaMinima(fecha);

		} catch (DateTimeParseException e) {
			throw new BadRequestException("Formato de fecha incorrecto", e);
		}
	}

}
