package br.com.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Historico_Treino")
public class Historico_Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_execucao", nullable = false)
    private LocalDateTime dataExecucao;

    @Column(name = "usuarioID", nullable = false)
    private Integer usuarioID;

    @Column(name = "treinoID", nullable = false)
    private Integer treinoID;
}
