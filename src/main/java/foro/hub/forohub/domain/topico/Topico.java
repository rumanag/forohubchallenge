package foro.hub.forohub.domain.topico;

import foro.hub.forohub.domain.curso.Curso;
import foro.hub.forohub.domain.respuesta.Respuesta;
import foro.hub.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @NotNull
    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuesta = new ArrayList<>();

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario, Curso curso){
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fechaCreacion= LocalDateTime.now();
        this.status=Status.NUEVO;
        this.activo= true;
        this.usuario = usuario;
        this.curso = curso;
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
