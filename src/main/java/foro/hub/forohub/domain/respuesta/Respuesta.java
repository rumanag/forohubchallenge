package foro.hub.forohub.domain.respuesta;

import foro.hub.forohub.domain.topico.Topico;
import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Table(name="respuestas")
@Entity(name="Respuesta")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mensaje;
    private Date fechaCreacion;
    private String solucion;
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topico")
    private Topico topico;
}
