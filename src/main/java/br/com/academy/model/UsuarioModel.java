package br.com.academy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser de espassos brancos")
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "O email não pode ser nulo")
    @Email
    private String email;

    @Column(name = "senha_hash", nullable = false)
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não pode ser de espassos brancos")
    @Length(min = 8)
    private String senha;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}
