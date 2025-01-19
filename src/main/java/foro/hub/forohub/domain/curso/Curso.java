package foro.hub.forohub.domain.curso;

import foro.hub.forohub.domain.curso.DatosCurso.DatosCurso;
import foro.hub.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Curso {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String nombreCurso;

        private String categoria;

        private boolean activo;

        @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Topico> topicos = new ArrayList<>();
}
