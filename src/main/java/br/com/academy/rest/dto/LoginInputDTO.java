package br.com.academy.rest.dto;

import lombok.Data;

@Data
public class LoginInputDTO {
    private String email;
    private String senha;
}
