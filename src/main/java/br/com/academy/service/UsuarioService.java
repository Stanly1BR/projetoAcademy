package br.com.academy.service;

import br.com.academy.exception.*;
import br.com.academy.model.UsuarioModel;
import br.com.academy.repositery.UsuarioRepositery;
import br.com.academy.rest.dto.UsuarioInputDTO;
import br.com.academy.rest.dto.UsuarioOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositery usuarioRepositery;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional(readOnly = true)
    public UsuarioInputDTO obterUsuarioPorEmail(String pEmail){
        UsuarioModel usuarioNovo = usuarioRepositery.findByEmail(pEmail).orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
        return modelMapper.map(usuarioNovo, UsuarioInputDTO.class);
    }

    /*@Transactional
    public List<UsuarioDTO> obterTodos(){
        List<UsuarioModel> usuariosNovo = usuarioRepositery.findAll();
        return usuariosNovo.stream().map(usuario -> modelMapper.map(usuario, UsuarioDTO.class)).collect(Collectors.toList());
    }*/

    @Transactional
    public UsuarioOutputDTO adicionarUsuario(UsuarioInputDTO input){
        if (usuarioRepositery.findByEmail(input.getEmail()).isPresent()) {
            throw new ConstraintException("Usuário já tem cadastrado");
        }
        UsuarioModel usuarioNovo = modelMapper.map(input, UsuarioModel.class);
        usuarioNovo.setSenha(encoder.encode(input.getSenha()));
        usuarioNovo.setDataCadastro(LocalDateTime.now());

        return modelMapper.map(usuarioRepositery.save(usuarioNovo), UsuarioOutputDTO.class);
    }

    /*@Transactional
    public UsuarioDTO atualizarUsuario(UsuarioModel input){
        return modelMapper.map(usuarioRepositery.save(input), UsuarioDTO.class);
    }*/

    @Transactional
    public void removerUsuario(Integer pId){
        if (!usuarioRepositery.existsById(pId)) {
            throw new ConstraintException("Usuário inexistente na base de dados!");
        }

        usuarioRepositery.deleteById(pId);
    }

    @Transactional(readOnly = true)
    public Boolean validarLoginESenha(String pEmail, String pSenha){
        Optional<UsuarioModel> usuario = usuarioRepositery.findByEmail(pEmail);

        if (usuario.isEmpty()){
            throw new ConstraintException("Usuário inexistente na base de dados!");
        }

        return encoder.matches(pSenha, usuario.get().getSenha());
    }
}
