package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.curso.Curso;
import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

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
    private boolean activo;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String idRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Topico(){}

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(String idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
