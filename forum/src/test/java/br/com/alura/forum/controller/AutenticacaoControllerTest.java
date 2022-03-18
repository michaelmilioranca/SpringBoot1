package br.com.alura.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

class AutenticacaoControllerTest extends BaseControllerTest {

    @Test
    void deveDevolverBadRequestQuandoUsuarioOuSenhaIncorreto() throws Exception {
        String json = "{\"email:\"invalida@email.com\", \"senha\":\"123456\"}";
        mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST, URI.create("/auth"))
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}