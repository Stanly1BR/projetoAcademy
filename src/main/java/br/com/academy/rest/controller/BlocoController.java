package br.com.academy.rest.controller;

import br.com.academy.rest.dto.BlocoInputDTO;
import br.com.academy.service.BlocoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bloco")
public class BlocoController {

    @Autowired
    private BlocoService blocoService;

    @GetMapping("/{id}")
    public ResponseEntity<BlocoInputDTO> buscarPorId(@PathVariable Integer id) {
        BlocoInputDTO bloco = blocoService.obterBlocoPorId(id);
        return ResponseEntity.ok().body(bloco);
    }

    @GetMapping
    public ResponseEntity<List<BlocoInputDTO>> listarTodos() {
        List<BlocoInputDTO> blocos = blocoService.obterTodosBlocos();
        return ResponseEntity.ok().body(blocos);
    }

    @PostMapping
    public ResponseEntity<BlocoInputDTO> criarBloco(@Valid @RequestBody BlocoInputDTO Input) {
        BlocoInputDTO novoBloco = blocoService.adicionarBloco(Input);
        return ResponseEntity.status(201).body(novoBloco);
    }

    @PutMapping
    public ResponseEntity<BlocoInputDTO> atualizarBloco(@Valid @RequestBody BlocoInputDTO Input) {
        BlocoInputDTO blocoAtualizado = blocoService.atualizarBloco(Input);
        return ResponseEntity.ok().body(blocoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBloco(@PathVariable Integer id) {
        blocoService.removerBloco(id);
        return ResponseEntity.noContent().build();
    }
}
