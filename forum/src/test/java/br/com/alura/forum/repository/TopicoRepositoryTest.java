package br.com.alura.forum.repository;

import br.com.alura.forum.Annotation.SqlTopico;
import br.com.alura.forum.modelo.Topico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopicoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private TopicoRepository repository;

    @Test
    @SqlTopico
    void deveRetornarTopicosQuandoBuscarPorNomeCurso(){
        Page<Topico> topicos = repository.findByCursoNome("HTML 5", Pageable.ofSize(10));
        assertEquals(2L, topicos.get().count());
    }

    @Test
    void deveRetornarNullQuandoNaoEncontrarTopicoParaONomeCurso(){
        Page<Topico> topicos = repository.findByCursoNome("Xablau", Pageable.ofSize(10));
        assertTrue(topicos.isEmpty());
    }
}