package foro.hub.forohub.domain.topico;

import jakarta.validation.constraints.Email;
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
        String curso,
        String respuesta,
        @NotNull
        Long usuarioId
) {
}
