package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.curso.Curso;
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

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    private String idRespuesta;

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario, Curso curso){
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fechaCreacion=datosRegistroTopico.fechaCreacion();
        this.status=datosRegistroTopico.status();
        this.idRespuesta=datosRegistroTopico.idRespuesta();
        this.activo= true;
        this.usuario = usuario;
        this.curso = curso;
    }

    public Topico(@Valid DatosRegistroTopico datosRegistroTopico, Usuario usuario) {
    }



    public void actualizarTopico(DatosActualizaTopico datosActualizaTopico) {

        if(datosActualizaTopico.mensaje() != null){
            this.mensaje = datosActualizaTopico.mensaje();
        }

        if(datosActualizaTopico.status() != null){
            this.status = datosActualizaTopico.status();
        }
       if(datosActualizaTopico.respuesta() !=null){
           this.idRespuesta= datosActualizaTopico.respuesta();
       }
    }

    public void desactivarTopico() {
        this.activo= false;
    }



}
