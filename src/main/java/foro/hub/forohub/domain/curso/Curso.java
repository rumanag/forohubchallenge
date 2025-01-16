package foro.hub.forohub.domain.curso;

import foro.hub.forohub.domain.curso.DatosCurso.DatosCurso;
import foro.hub.forohub.domain.topico.Topico;
import foro.hub.forohub.domain.usuario.DatosUsuario;
import foro.hub.forohub.domain.usuario.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@Table(name="cursos")
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

        @Id()
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String  nombreCurso;
        private String categoria;
        private boolean activo;

        @OneToMany(mappedBy = "curso")
        private List<Topico> topicos;


        public Curso(){}

        public Curso(DatosCurso curso) {
                this.nombreCurso = curso.nombre_curso();
                this.categoria = curso.categoria();
        }

}
