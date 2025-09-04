package br.com.academy.rest.controller;

import br.com.academy.rest.dto.UsuarioInputDTO;
import br.com.academy.rest.dto.UsuarioOutputDTO;
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
    public ResponseEntity<UsuarioInputDTO> buscarUsuarioPorEmail(@PathVariable String pEmail){
        UsuarioInputDTO buscarUsuario = usuarioService.obterUsuarioPorEmail(pEmail);
        return ResponseEntity.ok().body(buscarUsuario);
    }

    @PostMapping
     public ResponseEntity<UsuarioOutputDTO> cadastrarUsuario(@Valid @RequestBody UsuarioInputDTO input){
        UsuarioOutputDTO usuario = usuarioService.adicionarUsuario(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{pId}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer pId){
        usuarioService.removerUsuario(pId);
        return ResponseEntity.noContent().build();
    }
}
