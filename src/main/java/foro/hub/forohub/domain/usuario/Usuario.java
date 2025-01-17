package foro.hub.forohub.domain.usuario;

import foro.hub.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name="usuarios")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nombre;
    private String email;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Topico> topicos;

    public Usuario(DatosUsuario usuario){
        this.nombre = usuario.nombre();
        this.email = usuario.email();
        this.contrasena = usuario.contrasena();
    }


}
