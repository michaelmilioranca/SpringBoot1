package br.com.alura.forum.config;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {
    @Value("${forum.jwt.expiration}")
    private Long expiration;
    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date dataCriacao = new Date();
        Date dataExpiracao = new Date(dataCriacao.getTime() + expiration);
        return Jwts.builder()
                .setIssuer("API Fòrum ALURA")
                .setSubject(logado.getId().toString())
                .setIssuedAt(dataCriacao)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
