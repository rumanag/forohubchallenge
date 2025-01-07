package foro.hub.forohub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DatosPerfilUsuario(
        @NotBlank
        String nombrePerfil


) {
}
