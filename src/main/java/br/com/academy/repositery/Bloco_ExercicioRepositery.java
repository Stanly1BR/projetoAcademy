package br.com.academy.repositery;

import br.com.academy.model.Bloco_ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bloco_ExercicioRepositery extends JpaRepository<Bloco_ExercicioModel, Integer> {
}
