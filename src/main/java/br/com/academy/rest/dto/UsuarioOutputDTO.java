package br.com.academy.rest.dto;

import lombok.Data;

@Data
public class UsuarioOutputDTO {
    private String mensagem = "Usuário cadastrado com sucesso";
    private String nome;
    private int usuarioId;

}
