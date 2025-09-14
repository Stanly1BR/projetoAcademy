package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.ExercicioModel;
import br.com.academy.repositery.ExercicioRepositery;
import br.com.academy.rest.dto.ExercicioInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepositery exercicioRepositery;

    @Autowired
    private ModelMapper modelMapper;
    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */
    @Transactional(readOnly = true)
    private ExercicioInputDTO obterPorId(int pId){
        ExercicioModel exercicio = exercicioRepositery.findById(pId).orElseThrow(()-> new ObjectNotFoundException("Exercicio não encontrado"));
        return modelMapper.map(exercicio, ExercicioInputDTO.class);
    }

    @Transactional(readOnly = true)
    private List<ExercicioInputDTO> obterTodosExercicios(){
        List<ExercicioModel> ListaExercicios = exercicioRepositery.findAll();
        return ListaExercicios.stream().map(exercicioModel -> modelMapper.map(exercicioModel, ExercicioInputDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Transactional
    private ExercicioInputDTO adicionarExercicio(ExercicioInputDTO input){
        return modelMapper.map(exercicioRepositery.save(modelMapper.map(input, ExercicioModel.class)), ExercicioInputDTO.class);
    }

    @Transactional
    private ExercicioInputDTO atualizarExercicio(ExercicioInputDTO input){
        if (!exercicioRepositery.existsById(input.getId())){
            throw  new ObjectNotFoundException("Nenhum Exercicio encontrado com esse ID");
        }
        return modelMapper.map(exercicioRepositery.save(modelMapper.map(input, ExercicioModel.class)), ExercicioInputDTO.class);
    }

    @Transactional
    private void removerExercicio(int pId){
        if (!exercicioRepositery.existsById(pId)){
            throw  new ObjectNotFoundException("Nenhum Exercicio encontrado com esse ID");
        }
        exercicioRepositery.deleteById(pId);
    }

    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
