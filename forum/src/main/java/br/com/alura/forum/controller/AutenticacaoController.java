package br.com.alura.forum.controller;

import br.com.alura.forum.config.TokenService;
import br.com.alura.forum.controller.dto.TokenDto;
import br.com.alura.forum.controller.form.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.Valid;

@RestControllerAdvice
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authManager;
    private static String TIPO_TOKEN = "Bearer";
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            return ResponseEntity.ok(new TokenDto(tokenService.gerarToken(authentication), TIPO_TOKEN));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
