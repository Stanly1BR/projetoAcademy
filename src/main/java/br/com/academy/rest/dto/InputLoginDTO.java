package br.com.academy.rest.dto;

import lombok.Data;

@Data
public class InputLoginDTO {
    private String email;
    private String senha;
}
