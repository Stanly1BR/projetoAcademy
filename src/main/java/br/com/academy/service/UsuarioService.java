package br.com.academy.service;

import br.com.academy.exception.ObjectNotFoundException;
import br.com.academy.model.UsuarioModel;
import br.com.academy.repositery.UsuarioRepositery;
import br.com.academy.rest.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    public List<UsuarioDTO> obterTodos(){
        List<UsuarioModel> usuariosNovo = usuarioRepositery.findAll();
        return usuariosNovo.stream().map(usuario -> modelMapper.map(usuario, UsuarioDTO.class)).collect(Collectors.toList());
    }
    //   return modelMapper.map(pacienteRepository.save(novoPaciente), PacienteDTO.class);
    @Transactional
    public UsuarioDTO adicionarUsuario(UsuarioModel input){
        return modelMapper.map(usuarioRepositery.save(input), UsuarioDTO.class);
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioModel input){
        return modelMapper.map(usuarioRepositery.save(input), UsuarioDTO.class);
    }

    @Transactional
    public void removerUsuario(UsuarioModel input){
        usuarioRepositery.delete(input);
    }
}
