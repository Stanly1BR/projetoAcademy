package br.com.academy.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
}
