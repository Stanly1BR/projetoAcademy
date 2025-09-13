package br.com.academy.repositery;

import br.com.academy.model.Historico_ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Historico_ExercicioRepositery extends JpaRepository<Historico_ExercicioModel, Integer> {
}
