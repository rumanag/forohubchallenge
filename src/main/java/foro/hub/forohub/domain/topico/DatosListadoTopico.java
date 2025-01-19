package foro.hub.forohub.domain.topico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record DatosListadoTopico(
              Long id,
              String titulo,
              String mensaje,
              LocalDateTime fechaCreacion,
              Boolean activo,
              Status status,
              Long idCurso,
              Long idUsuario
              )
{
        public DatosListadoTopico(Topico topico) {
            this(topico.getId(),
                 topico.getTitulo(),
                 topico.getMensaje(),
                 topico.getFechaCreacion(),
                 topico.getActivo(),
                 topico.getStatus(),
                 topico.getCurso().getId(),
                 topico.getUsuario().getId()
                 );
        }
}



