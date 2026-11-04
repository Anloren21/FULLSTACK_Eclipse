package com.ipartube.dtos;

import java.time.LocalDateTime;

public record ComentarioDto(Long id, LocalDateTime fechaHora, String nombre, String texto) {

}
