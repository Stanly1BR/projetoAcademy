package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.Historico_TreinoModel;
import br.com.academy.repositery.Historico_TreinoRepositery;
import br.com.academy.rest.dto.Historico_TreinoInputDTO;
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
public class Historico_TreinoService {
    @Autowired
    private Historico_TreinoRepositery historico_TreinoRepositery;

    @Autowired
    private ModelMapper modelMapper;
    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */

    @Transactional(readOnly = true)
    private Historico_TreinoInputDTO buscarPorId(int pId){
        Historico_TreinoModel historicoTreino = historico_TreinoRepositery.findById(pId).
                orElseThrow(()-> new ObjectNotFoundException("Historico do Treino não encontrado"));
        return modelMapper.map(historicoTreino, Historico_TreinoInputDTO.class);
    }

    @Transactional(readOnly = true)
    private List<Historico_TreinoInputDTO> buscarTodos(){
        List<Historico_TreinoModel> historicoTreinos = historico_TreinoRepositery.findAll();
        return historicoTreinos.stream().map(Historico_TreinoModel -> modelMapper.map(Historico_TreinoModel, Historico_TreinoInputDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    private Historico_TreinoInputDTO adicionarHistoricoTreino(Historico_TreinoInputDTO input){
        return modelMapper.map(historico_TreinoRepositery.save(modelMapper.map(input, Historico_TreinoModel.class)), Historico_TreinoInputDTO.class);
    }

    @Transactional
    private Historico_TreinoInputDTO atualizarHistoricoTreino(Historico_TreinoInputDTO input){
        if (!historico_TreinoRepositery.existsById(input.getId())){
            throw  new ObjectNotFoundException("Nenhum Historico de Treino encontrado com esse ID");
        }
        return modelMapper.map(historico_TreinoRepositery.save(modelMapper.map(input, Historico_TreinoModel.class)), Historico_TreinoInputDTO.class);
    }

    @Transactional
    private void removerHistoricoTreino(int pId){
        if (!historico_TreinoRepositery.existsById(pId)){
            throw  new ObjectNotFoundException("Nenhum Historico de Treino encontrado com esse ID");
        }
        historico_TreinoRepositery.deleteById(pId);
    }


    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
