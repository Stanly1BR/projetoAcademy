package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.Bloco_ExercicioModel;
import br.com.academy.repositery.Bloco_ExercicioRepositery;
import br.com.academy.rest.dto.Bloco_ExercicioInputDTO;
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
public class Bloco_ExercicioService {

    @Autowired
    private Bloco_ExercicioRepositery bloco_ExercicioRepositery;

    @Autowired
    private ModelMapper modelMapper;

    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */

    @Transactional(readOnly = true)
    public Bloco_ExercicioInputDTO obterPorId(int pId){
        Bloco_ExercicioModel blocoExercicio = bloco_ExercicioRepositery.findById(pId).orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado o bloco de exercicio"));
        return modelMapper.map(blocoExercicio, Bloco_ExercicioInputDTO.class);
    }

    @Transactional(readOnly = true)
    public List<Bloco_ExercicioInputDTO> obterTodosOsBlocosExercicios(){
        List<Bloco_ExercicioModel> ListaBlocosExercicios = bloco_ExercicioRepositery.findAll();
        return ListaBlocosExercicios.stream().map(blocoExercicio -> modelMapper.map(blocoExercicio, Bloco_ExercicioInputDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Transactional
    public Bloco_ExercicioInputDTO adicionarBlocoExercicio(Bloco_ExercicioInputDTO input){
        return modelMapper.map(bloco_ExercicioRepositery.save(modelMapper.map(input, Bloco_ExercicioModel.class)), Bloco_ExercicioInputDTO.class);
    }

    @Transactional
    public Bloco_ExercicioInputDTO atualizarBlocoExercicio(Bloco_ExercicioInputDTO input){
        if (bloco_ExercicioRepositery.existsById(input.getId_bloco_exercicio())){
            throw new ObjectNotFoundException("Não foi encontrado o bloco de exercicio");
        }
        return modelMapper.map(bloco_ExercicioRepositery.save(modelMapper.map(input, Bloco_ExercicioModel.class)), Bloco_ExercicioInputDTO.class);
    }
    @Transactional
    public void removerBlocoExercicio(int pId){
        if (!bloco_ExercicioRepositery.existsById(pId)){
            throw  new ObjectNotFoundException("Nenhum Bloco de Exercicio encontrado com esse ID");
        }
        bloco_ExercicioRepositery.deleteById(pId);
    }
    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
