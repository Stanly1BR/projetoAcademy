package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.UsuarioModel;
import br.com.academy.repositery.UsuarioRepositery;
import br.com.academy.rest.dto.UsuarioDTO;
import br.com.academy.rest.dto.UsuarioInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositery usuarioRepositery;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public UsuarioDTO obterUsuarioPorEmail(String pEmail){
        UsuarioModel usuarioNovo = usuarioRepositery.findByEmail(pEmail).orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
        return modelMapper.map(usuarioNovo, UsuarioDTO.class);
    }
}
