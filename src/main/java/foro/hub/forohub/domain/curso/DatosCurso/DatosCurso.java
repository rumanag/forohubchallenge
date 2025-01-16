package foro.hub.forohub.domain.curso.DatosCurso;

import foro.hub.forohub.domain.usuario.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosCurso(


        @NotBlank
        String  nombre_curso,
        @NotBlank
        String categoria
) {}
