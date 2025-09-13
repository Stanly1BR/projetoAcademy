package br.com.academy.repositery;

import br.com.academy.model.ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepositery extends JpaRepository<ExercicioModel, Integer> {
}
