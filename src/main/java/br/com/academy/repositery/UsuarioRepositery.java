package br.com.academy.repositery;

import br.com.academy.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositery extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByEmail(String pEmail);
}
