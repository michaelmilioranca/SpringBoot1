package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Resposta;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RespostaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDto(Resposta resposta) {
        new RespostaDto(resposta.getId(), resposta.getMensagem(), resposta.getDataCriacao(), resposta.getAutor().getNome());
    }
}
