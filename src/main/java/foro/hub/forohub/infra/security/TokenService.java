package foro.hub.forohub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import foro.hub.forohub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;



//@Service
//public class TokenService {
//
//    @Value("${api.security.secret}")
//    private String apiSecret;
//
//
//    public String generarToken(Usuario usuario){
//
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
//            return JWT.create()
//                    .withIssuer("foroHub")
//                    .withSubject(usuario.getNombre())
//                    .withClaim("id", usuario.getId())
//                    .withExpiresAt(generarFechaExpiracion())
//                    .sign(algorithm);
//        } catch (JWTCreationException exception){
//            throw new RuntimeException();
//        }
//    }
//
//    private Instant generarFechaExpiracion(){
//
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
//    }
//}
@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(Usuario user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("API")
                    .withSubject(user.getNombre())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating JWT token", exception);
        }
    }

    public String getSubject(String tokenJWT) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.require(algorithm)
                    .withIssuer("API")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid or expired JWT token");
        }
    }

    //se cambio .plusMinutes a .plusHours para extender el tiempo del token
    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}


