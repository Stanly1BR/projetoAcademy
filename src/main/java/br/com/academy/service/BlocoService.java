package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.BlocoModel;
import br.com.academy.repositery.BlocoRepositery;
import br.com.academy.rest.dto.BlocoInputDTO;
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
public class BlocoService {

    @Autowired
    private BlocoRepositery blocoRepositery;

    @Autowired
    private ModelMapper modelMapper;

    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */

    @Transactional(readOnly = true)
    public BlocoInputDTO obterBlocoPorId(int pId){
        BlocoModel bloco = blocoRepositery.findById(pId).orElseThrow(()-> new ObjectNotFoundException("Bloco não encontrado"));
        return modelMapper.map(bloco, BlocoInputDTO.class);
    }

    @Transactional(readOnly = true)
    public List<BlocoInputDTO> obterTodosBlocos(){
        List<BlocoModel> ListaBlocos = blocoRepositery.findAll();
        return ListaBlocos.stream().map(blocoModel -> modelMapper.map(blocoModel, BlocoInputDTO.class)).collect(java.util.stream.Collectors.toList());
    }
    @Transactional
    public BlocoInputDTO adicionarBloco(BlocoInputDTO input){
        return modelMapper.map(blocoRepositery.save(modelMapper.map(input, BlocoModel.class)), BlocoInputDTO.class);
    }

    @Transactional
    public BlocoInputDTO atualizarBloco(BlocoInputDTO input){
        if (!blocoRepositery.existsById(input.getId())){
            throw  new ObjectNotFoundException("Nenhum Bloco encontrado com esse ID");
        }
        return modelMapper.map(blocoRepositery.save(modelMapper.map(input, BlocoModel.class)), BlocoInputDTO.class);
    }

    @Transactional
    public void removerBloco(int pId){
        if (!blocoRepositery.existsById(pId)){
            throw  new ObjectNotFoundException("Nenhum Bloco encontrado com esse ID");
        }
        blocoRepositery.deleteById(pId);
    }

    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
