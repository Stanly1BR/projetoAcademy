package br.com.academy.repositery;

import br.com.academy.model.Historico_Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Historico_TreinoRepositery extends JpaRepository<Historico_Treino, Integer> {
}
