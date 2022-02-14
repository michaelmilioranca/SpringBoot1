package br.com.alura.forum.Annotation;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.lang.annotation.Retention;

import static br.com.alura.forum.repository.ScriptsRepo.DELETE_USUARIO;
import static br.com.alura.forum.repository.ScriptsRepo.INSERT_USUARIO;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SqlGroup({@Sql(scripts = INSERT_USUARIO, executionPhase = BEFORE_TEST_METHOD),
        @Sql(scripts = DELETE_USUARIO, executionPhase = AFTER_TEST_METHOD)})
@Retention(RUNTIME)
public @interface SqlUsuario {
}
