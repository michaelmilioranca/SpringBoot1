package br.com.alura.forum.config.security;

import com.google.common.net.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private static String PRE_FIXO_BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = obterToken(httpServletRequest);
    }

    private String obterToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if(token.isEmpty() || token == null || !token.startsWith(PRE_FIXO_BEARER)){
            return null;
        }
        return token.substring(7);
    }
}
