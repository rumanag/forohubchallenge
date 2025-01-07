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
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Topico {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String titulo;
    private String mensaje;
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String curso;
    private String respuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario){
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fechaCreacion=datosRegistroTopico.fechaCreacion();
        this.status=datosRegistroTopico.status();
        this.curso=datosRegistroTopico.curso();
        this.respuesta=datosRegistroTopico.respuesta();
        this.usuario = usuario;

    }
}
