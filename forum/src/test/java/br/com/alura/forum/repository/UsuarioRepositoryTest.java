package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    void deveEncontrarUsuarioPorEmail(){
        Optional<Usuario> usuario = repository.findByEmail("aluno@email.com");
        assertTrue(usuario.isPresent());
        assertEquals("aluno@email.com", usuario.get().getEmail());
    }

    @Test
    void deveRetornarNullQuandoNaoEncontrarUsuario(){
        Optional<Usuario> usuario = repository.findByEmail("aluno321@email.com");
        assertFalse(usuario.isPresent());
    }
}