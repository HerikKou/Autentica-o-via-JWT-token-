package Autenticacao.Autenticacao.Service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;



@Service
public class JwtUtil {
    private final static String SECRET_KEY = "MinhaChave123";// Define a chave
    private static final String ISSUER = "pizzurg-api";// emissor

    public static String generatedToken(String username) {// Método que vai gerar o token
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); // Define o algoritmo HMAC SHA256 para criar a assinatura
                                                             // do token passando a chave secreta definida
        return JWT.create().withIssuer(ISSUER)// define o emissor
                .withSubject(username)//subject -assunto
                .withIssuedAt(new Date())// define a data
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))// define a hora de expiração
                .sign(algorithm);// Assina o token usando o algoritmo especificado

    }

    public static String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.require(algorithm)
                .withIssuer(ISSUER)// Define o emissor do token
                .build()
                .verify(token)//Verifica a validade do token
                .getSubject();// Obtém o assunto
    }

}
