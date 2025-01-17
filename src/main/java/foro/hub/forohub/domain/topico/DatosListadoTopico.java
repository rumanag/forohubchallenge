package foro.hub.forohub.domain.topico;

import java.util.Date;

public record DatosListadoTopico(
              Long id,
              String titulo,
              String mensaje,
              Date fechaCreacion,
              Boolean activo,
              Status status,
              Long idCurso,
              Long idUsuario,
              Long idRespuesta
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
                 topico.getUsuario().getId(),
                 topico.getRespuesta().getId());
        }
}



