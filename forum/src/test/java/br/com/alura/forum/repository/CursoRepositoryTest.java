package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.*;

@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    void deveBuscarPorNomeDeCurso() {
        Curso curso = repository.findByNome("HTML 5");
        assertNotNull(curso);
        assertEquals("HTML 5", curso.getNome());
    }

    @Test
    void deveRetornarNullQuandoNaoEncontrarCurso() {
        Curso curso = repository.findByNome("JPA");
        assertNull(curso);
    }

}