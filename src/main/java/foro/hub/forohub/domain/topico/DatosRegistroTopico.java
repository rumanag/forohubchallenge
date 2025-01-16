package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        Date fechaCreacion,
        @NotNull
        Status status,
        @NotBlank
        Boolean activo,
        @NotNull
        Long idCurso,
        @NotNull
        Long idUsuario,
        String idRespuesta
) {}
