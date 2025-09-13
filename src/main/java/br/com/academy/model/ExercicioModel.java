package br.com.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Exercicio")
public class ExercicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_exercicio", nullable = false)
    private String nome_exercicio;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "imagem_exercicio", nullable = false)
    private String imagem_exercicio;
}
