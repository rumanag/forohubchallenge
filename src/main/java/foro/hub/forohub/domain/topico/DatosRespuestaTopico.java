package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.util.Date;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje,Date fechaCreacion,Status status,
                                   String curso,String respuesta,Usuario usuario)
{}