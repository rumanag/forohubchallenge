package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.curso.Curso;
import foro.hub.forohub.domain.respuesta.Respuesta;
import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.util.Date;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Boolean activo,
        Status status,
        Curso curso,
        Usuario usuario,
        Respuesta respuesta)
{}