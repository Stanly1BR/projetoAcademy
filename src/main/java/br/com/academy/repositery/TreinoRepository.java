package br.com.academy.repositery;

import br.com.academy.model.TreinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<TreinoModel, Integer> {
}
