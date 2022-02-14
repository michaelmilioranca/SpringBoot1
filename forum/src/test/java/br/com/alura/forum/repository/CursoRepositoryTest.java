package br.com.alura.forum.repository;

import br.com.alura.forum.Annotation.SqlCurso;
import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Sql
class CursoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    @SqlCurso
    void deveBuscarPorNomeDeCurso() {
        Curso curso = repository.findByNome("HTML 5");
        assertNotNull(curso);
        assertEquals("HTML 5", curso.getNome());
    }

    @Test
    @SqlCurso
    void deveRetornarNullQuandoNaoEncontrarCurso() {
        Curso curso = repository.findByNome("JPA");
        Assertions.assertNull(curso);
    }

}