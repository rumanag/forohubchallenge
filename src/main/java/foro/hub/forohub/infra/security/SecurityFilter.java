package foro.hub.forohub.infra.security;

import foro.hub.forohub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // OBTENER EL TOKEN DEL HEADER
        var authHeader = request.getHeader("Authorization");//replace("Bearer","");

        if (authHeader != null) {

            var token = authHeader.replace("bearer", "");
            var nombreUsuario = tokenService.getSubject(token);

            if (nombreUsuario != null) {

                var usuario = usuarioRepository.findByNombre(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities()); // FORZAR INICIO DE SESIÓN

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }

        filterChain.doFilter(request, response);
    }
}