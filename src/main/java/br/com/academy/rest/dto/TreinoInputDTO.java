package br.com.academy.rest.dto;

import lombok.Data;

@Data
public class TreinoInputDTO {

    private int id;
    private String nomeTreino;
    private Integer usuarioID;
}
