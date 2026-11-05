
package com.ipartex.accesodatos.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import com.ipartex.accesodatos.DaoMensaje;
import com.ipartex.entidades.Mensaje;

import bibliotecas.accesodatos.AccesoDatosException;
import bibliotecas.accesodatos.JdbcHelper;
import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

public class DaoMensajeSqlite implements DaoMensaje {
	@SuppressWarnings("unchecked")
	private JdbcHelper<Mensaje> jdbc = (JdbcHelper<Mensaje>) ContenedorInyeccionDependencias
			.obtenerObjeto("jdbc.helper");

	private static Mensaje mapper(ResultSet rs) {
		try {
			String fechaTexto = rs.getString("fecha_hora");

			LocalDateTime fechaHora;

			if (fechaTexto.length() == 10) {
				fechaHora = LocalDate.parse(fechaTexto).atStartOfDay();
			} else {
				fechaHora = LocalDateTime.parse(fechaTexto.replace(" ", "T"));
			}

			return new Mensaje(rs.getLong("id"), rs.getString("nombre"), rs.getString("texto"), fechaHora);

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido mapear el objeto", e);
		}
	}

	private static Mensaje mapperId(ResultSet rs) {
		try {
			return new Mensaje(rs.getLong(1), null, null, null);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido mapear el ID", e);
		}
	}

	@Override
	public Iterable<Mensaje> obtenerTodos() {
		return jdbc.ejecutarSql("SELECT * FROM mensajes", DaoMensajeSqlite::mapper);
	}

	@Override
	public Iterable<Mensaje> obtenerParaPantalla() {
		return jdbc.ejecutarSql("SELECT * FROM mensajes ORDER BY fecha_hora DESC", DaoMensajeSqlite::mapper);
	}

	@Override
	public Optional<Mensaje> obtenerPorId(Long id) {
		return jdbc.ejecutarUnoSql("SELECT * FROM mensajes WHERE id=?", DaoMensajeSqlite::mapper, id);
	}

	@Override
	public Mensaje insertar(Mensaje mensaje) {
		mensaje.setId(jdbc
				.ejecutarUnoSql(
						"INSERT INTO mensajes " + "(nombre, texto, fecha_hora) " + "VALUES (?,?,?) RETURNING id",
						DaoMensajeSqlite::mapperId, mensaje.getNombre(), mensaje.getTexto(),
						mensaje.getFechaHora().toString())
				.orElseThrow(() -> new AccesoDatosException("No se ha podido recuperar el ID insertado")).getId());

		return mensaje;
	}

	@Override
	public Mensaje modificar(Mensaje mensaje) {
		jdbc.ejecutarSql("UPDATE mensajes " + "SET nombre=?, texto=?, fecha_hora=? " + "WHERE id=?", null,
				mensaje.getNombre(), mensaje.getTexto(), mensaje.getFechaHora().toString(), mensaje.getId());

		return mensaje;
	}

	@Override
	public void borrar(Long id) {
		jdbc.ejecutarSql("DELETE FROM mensajes WHERE id=?", null, id);
	}
}
