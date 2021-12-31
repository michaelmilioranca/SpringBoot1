package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DataJpaTest
class TopicoRepositoryTest {

    @Autowired
    private TopicoRepository repository;

    @Test
    void deveRetornarTopicosQuandoBuscarPorNomeCurso(){
        Page<Topico> topicos = repository.findByCursoNome("Spring Boot", Pageable.ofSize(10));
        assertEquals(2L, topicos.get().count());
    }

    @Test
    void deveRetornarNullQuandoNaoEncontrarTopicoParaONomeCurso(){
        Page<Topico> topicos = repository.findByCursoNome("Xablau", Pageable.ofSize(10));
        assertTrue(topicos.isEmpty());
    }
}