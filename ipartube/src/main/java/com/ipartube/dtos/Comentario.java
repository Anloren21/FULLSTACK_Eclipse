package com.ipartube.dtos;

import java.time.LocalDateTime;

public record Comentario(Long id, LocalDateTime fechaHora, String nombre, String texto) {

}
