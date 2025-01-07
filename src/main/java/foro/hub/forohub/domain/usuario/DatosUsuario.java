package foro.hub.forohub.domain.usuario;

import foro.hub.forohub.domain.perfil.DatosPerfilUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosUsuario(

        @NotBlank
        String  nombre,

        @NotBlank
        String correoElectronico,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String contrasena,
        @NotNull
        DatosPerfilUsuario datosPerfilUsuario
) {
}

