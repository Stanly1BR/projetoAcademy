package br.com.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Historico_Exercicio")
public class Historico_ExercicioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historico_exercicio;

    @Column(name = "historicoID", nullable = false)
    private Integer historicoID;

    @Column(name = "bloco_exercicioID", nullable = false)
    private Integer bloco_exercicioID;

    @Column(name = "series", nullable = false)
    private Integer series;

    @Column(name = "carga", nullable = false)
    private Integer carga;
}
