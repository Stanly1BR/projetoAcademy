package br.com.academy.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Historico_TreinoInputDTO {

    private int id;
    private LocalDateTime dataExecucao;
    private Integer usuarioID;
    private Integer treinoID;
}
