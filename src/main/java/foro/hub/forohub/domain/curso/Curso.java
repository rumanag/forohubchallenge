package foro.hub.forohub.domain.curso;

import foro.hub.forohub.domain.curso.DatosCurso.DatosCurso;
import foro.hub.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="cursos")
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


        public Curso(DatosCurso curso) {
                this.nombreCurso = curso.nombre_curso();
                this.categoria = curso.categoria();
        }

}
