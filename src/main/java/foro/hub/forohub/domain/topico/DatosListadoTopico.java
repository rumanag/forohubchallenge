package foro.hub.forohub.domain.topico;

import java.util.Date;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Status status,
        String curso,
        String respuesta,
        Long IdUsuario){

        public DatosListadoTopico(Topico topico) {
            this(topico.getId(), topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(),
                 topico.getStatus(), topico.getCurso().getId(), topico.getIdRespuesta(),topico.getUsuario().getId());
        }
}



