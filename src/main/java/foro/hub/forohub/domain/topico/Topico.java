package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.curso.Curso;
import foro.hub.forohub.domain.respuesta.Respuesta;
import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Date;

@Table(name="topicos")
@Entity(name="Topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_respuesta")
    private Respuesta respuesta;

    public Topico(@Valid DatosRegistroTopico datosRegistroTopico){
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fechaCreacion=datosRegistroTopico.fechaCreacion();
        this.status=datosRegistroTopico.status();
        this.activo= true;
        this.usuario = usuario;
        this.curso = curso;
        this.respuesta = respuesta;
    }

    public void actualizarTopico(DatosActualizaTopico datosActualizaTopico) {

        if(datosActualizaTopico.mensaje() != null){
            this.mensaje = datosActualizaTopico.mensaje();
        }

        if(datosActualizaTopico.status() != null){
            this.status = datosActualizaTopico.status();
        }
    }

    public void desactivarTopico() {
        this.activo= false;
    }



}
