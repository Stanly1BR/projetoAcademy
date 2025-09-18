package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.Historico_ExercicioModel;
import br.com.academy.repositery.Historico_ExercicioRepositery;
import br.com.academy.rest.dto.Historico_ExercicioInputDTO;
import br.com.academy.rest.dto.Historico_TreinoInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class Historico_ExercicioService {

    @Autowired
    private Historico_ExercicioRepositery historico_ExercicioRepositery;

    @Autowired
    private ModelMapper modelMapper;
    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */

    @Transactional(readOnly = true)
    public Historico_ExercicioInputDTO obterHistoricoExercicioPorId(int pId){
        Optional<Historico_ExercicioModel> historicoTreino = historico_ExercicioRepositery.findById(pId);
        return modelMapper.map(historicoTreino, Historico_ExercicioInputDTO.class);
    }

    @Transactional(readOnly = true)
    public List<Historico_ExercicioInputDTO> obterTodosOsHistoricoExercicios(){
        List<Historico_ExercicioModel> ListaHistoricoExercicios = historico_ExercicioRepositery.findAll();
        return ListaHistoricoExercicios.stream().map(historicoExercicioModel ->
                modelMapper.map(historicoExercicioModel, Historico_ExercicioInputDTO.class)).collect(java.util.stream.Collectors.toList());
    }

    @Transactional
    public Historico_ExercicioInputDTO adicionarHistoricoExercicio(Historico_ExercicioInputDTO input){
        return modelMapper.map(historico_ExercicioRepositery.save(modelMapper.map(input, Historico_ExercicioModel.class))
                , Historico_ExercicioInputDTO.class);
    }

    @Transactional
    public Historico_ExercicioInputDTO alterarrHistoricoExercicio(Historico_ExercicioInputDTO input){
        if (!historico_ExercicioRepositery.existsById(input.getId_historico_exercicio())){
            throw new ObjectNotFoundException("Historico do exercicio não encontrado");
        }
        return modelMapper.map(historico_ExercicioRepositery.save(modelMapper.map(input, Historico_ExercicioModel.class)), Historico_ExercicioInputDTO.class);
    }

    @Transactional
    public void deletarHistoricoExercicio(int pId){
        if (!historico_ExercicioRepositery.existsById(pId)){
            throw new ObjectNotFoundException("Historico do exercicio não encontrado");
        }
        historico_ExercicioRepositery.deleteById(pId);
    }

    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
