package com.ipartube.accesodatos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartube.dtos.VideoDto;
import com.ipartube.entidades.*;
import com.ipartube.dtos.VideoInsertarDto;
import com.ipartube.dtos.VideoInsertarRespuestaDto;

import bibliotecas.accesodatos.AccesoDatosException;
import bibliotecas.accesodatos.BaseDeDatos;
import bibliotecas.accesodatos.Dao;

public class VideoCrud implements DaoVideo{
	@Override
	//TODO: Añadir usuario
	public ArrayList<Video> obtenerTodos() {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT * FROM videos");
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Video> videos = new ArrayList<Video>();

			while (rs.next()) {
				Video video = new Video(rs.getLong("id"), rs.getDate("fecha").toLocalDate(), rs.getString("url"),
						rs.getString("titulo"), rs.getString("descripcion"));
				videos.add(video);
			}

			return videos;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener los videos", e);
		}
	}

	@Override
	//TODO: Añadir usuario
	public Video obtenerPorId(Long id) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT * FROM videos WHERE id=?")) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			Video video = null;
			
			while (rs.next()) {
				video = new Video(rs.getLong("id"), rs.getDate("fecha").toLocalDate(), rs.getString("url"),
						rs.getString("titulo"), rs.getString("descripcion"));
			}

			return video;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener el video " + id, e);
		}
	}
	
	@Override
	public Video insertar(Video video) {
		try (CallableStatement cst = BaseDeDatos.crearProcedimiento("call videos_insert(?,?,?,?,?,?)")) {
			cst.registerOutParameter(1, Types.BIGINT);
			cst.registerOutParameter(2, Types.DATE);
			cst.setString(3, video.getUrl());
			cst.setString(4, video.getTitulo());
			cst.setString(5, video.getDescripcion());
			cst.setLong(6, video.getUsuario().getId());

			cst.executeUpdate();
			video.setId(cst.getLong(1));
			video.setFecha(cst.getDate(2).toLocalDate());
			
			
			return video;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener el video " + video, e);
		}
	}

	@Override
	public Video modificar(Video o) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
