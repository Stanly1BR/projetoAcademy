package br.com.academy.rest.dto;

import lombok.Data;

@Data
public class ExercicioInputDTO {

    private int id;
    private String nome_exercicio;
    private String descricao;
    private String imagem_exercicio;
}
