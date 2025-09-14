package br.com.academy.repositery;

import br.com.academy.model.Historico_TreinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Historico_TreinoRepositery extends JpaRepository<Historico_TreinoModel, Integer> {
}
