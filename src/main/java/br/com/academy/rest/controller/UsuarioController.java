package br.com.academy.rest.controller;

import br.com.academy.model.UsuarioModel;
import br.com.academy.rest.dto.UsuarioDTO;
import br.com.academy.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{pEmail}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@PathVariable String pEmail){
        UsuarioDTO buscarUsuario = usuarioService.obterUsuarioPorEmail(pEmail);
        return ResponseEntity.ok().body(buscarUsuario);
    }

    @PostMapping
     public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid @RequestBody UsuarioModel input){
        UsuarioDTO usuario = usuarioService.adicionarUsuario(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping
    public void deletarUsuario(@Valid @RequestBody UsuarioModel input){
        usuarioService.removerUsuario(input);
    }
}
