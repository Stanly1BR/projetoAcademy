package br.com.academy.rest.dto;

import lombok.Data;

@Data
public class Historico_ExercicioInputDTO {

    private int id_historico_exercicio;
    private Integer historicoID;
    private Integer bloco_exercicioID;
    private Integer series;
    private Integer carga;
}
