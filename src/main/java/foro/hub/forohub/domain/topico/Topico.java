package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name="topicos")
@Entity(name="Topico")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String mensaje;
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String curso;
    private String respuesta;
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico(){
    }

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario){
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fechaCreacion=datosRegistroTopico.fechaCreacion();
        this.status=datosRegistroTopico.status();
        this.curso=datosRegistroTopico.curso();
        this.respuesta=datosRegistroTopico.respuesta();
        this.activo= true;
        this.usuario = usuario;

    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Status getStatus() {
        return status;
    }

    public String getCurso() {
        return curso;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void actualizarTopico(DatosActualizaTopico datosActualizaTopico) {

        if(datosActualizaTopico.mensaje() != null){
            this.mensaje = datosActualizaTopico.mensaje();
        }

        if(datosActualizaTopico.status() != null){
            this.status = datosActualizaTopico.status();
        }
       if(datosActualizaTopico.respuesta() !=null){
           this.respuesta= datosActualizaTopico.respuesta();
       }
    }

    public void desactivarTopico() {
        this.activo= false;
    }
}
