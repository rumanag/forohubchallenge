package foro.hub.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Status status,
        String curso,
        String respuesta,
        Long usuarioId ){

        public DatosListadoTopico(Topico topico) {
            this(topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(),
                 topico.getStatus(), topico.getCurso(), topico.getRespuesta(),topico.getUsuario().getId());
        }
}



