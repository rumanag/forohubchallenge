package foro.hub.forohub.domain.usuario;

import foro.hub.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name="usuarios")
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nombre;
    private String correoElectronico;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Topico> topicos;

    public Usuario(){}

    public Usuario(DatosUsuario usuario){
        this.nombre = usuario.nombre();
        this.correoElectronico = usuario.correoElectronico();
        this.contrasena = usuario.contrasena();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }
}
