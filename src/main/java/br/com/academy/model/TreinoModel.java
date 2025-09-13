package br.com.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Treino")
public class TreinoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_treino", nullable = false)
    private String nomeTreino;

    @Column(name = "usuarioID", nullable = false)
    private Integer usuarioID;
}
