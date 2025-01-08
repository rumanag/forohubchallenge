package foro.hub.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosActualizaTopico(
        @NotNull Long id,
        String mensaje,
        Status status,
        String respuesta,
        Long usuarioId) {}

