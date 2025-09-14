package br.com.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Bloco")
public class BlocoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_bloco", nullable = false)
    private String nomeBloco;

    @Column(name = "TreinoID", nullable = false)
    private Integer TreinoID;
}
