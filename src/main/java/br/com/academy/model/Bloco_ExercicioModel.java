package br.com.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Bloco_Exercicio")
public class Bloco_ExercicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_bloco_exercicio;

    @Column(name = "BlocoID", nullable = false)
    private Integer BlocoID;

    @Column(name = "ExercicioID", nullable = false)
    private Integer ExercicioID;
}
