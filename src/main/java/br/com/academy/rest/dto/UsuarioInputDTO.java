package br.com.academy.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioInputDTO {
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
}
