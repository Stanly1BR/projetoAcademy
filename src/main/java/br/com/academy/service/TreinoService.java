package br.com.academy.service;

import br.com.academy.exception.ConstraintException;
import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.TreinoModel;
import br.com.academy.repositery.TreinoRepository;
import br.com.academy.rest.dto.TreinoInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private ModelMapper modelMapper;
    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */

    @Transactional(readOnly = true)
    private TreinoInputDTO obterTreinoPorId(int pId){
        TreinoModel treino = treinoRepository.findById(pId).orElseThrow(()-> new ObjectNotFoundException("Treino não encontrado no banco de dados"));
        return modelMapper.map(treino, TreinoInputDTO.class);
    }

    @Transactional(readOnly = true)
    private List<TreinoInputDTO> obterTodosOsTreinos(){
        List<TreinoModel> ListaTreinos = treinoRepository.findAll();
        return ListaTreinos.stream().map(treinoModel -> modelMapper.map(treinoModel, TreinoInputDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    private TreinoInputDTO adicionarTreino(TreinoInputDTO input){
        return modelMapper.map(treinoRepository.save(modelMapper.map(input, TreinoModel.class)), TreinoInputDTO.class);
    }

    @Transactional
    private TreinoModel atualizarTreino(TreinoInputDTO input){
        if (!treinoRepository.existsById(input.getId())){
            throw  new ObjectNotFoundException("Nenhum Treino encontrado com esse ID");
        }
        return modelMapper.map(treinoRepository.save(modelMapper.map(input, TreinoModel.class)), TreinoModel.class);
    }

    @Transactional
    private void removerTreino(int pId){
        if (!treinoRepository.existsById(pId)){
            throw  new ObjectNotFoundException("Nenhum Treino encontrado com esse ID");
        }
        treinoRepository.deleteById(pId);
    }


    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
