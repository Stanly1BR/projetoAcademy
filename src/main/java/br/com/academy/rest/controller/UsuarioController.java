package br.com.academy.rest.controller;

import br.com.academy.rest.dto.UsuarioDTO;
import br.com.academy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
