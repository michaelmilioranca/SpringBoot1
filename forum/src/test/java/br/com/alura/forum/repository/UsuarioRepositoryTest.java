package br.com.alura.forum.repository;

import br.com.alura.forum.Annotation.SqlUsuario;
import br.com.alura.forum.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    @SqlUsuario
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