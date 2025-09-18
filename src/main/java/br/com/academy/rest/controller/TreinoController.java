package br.com.academy.rest.controller;

import br.com.academy.rest.dto.TreinoInputDTO;
import br.com.academy.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Treino")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    /*
     * ===================================================================================
     * CRUD PADRÃO (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     * ===================================================================================
     * */

    @GetMapping("/{pId}")
    public ResponseEntity<TreinoInputDTO> obterTreinoPorId(@PathVariable int pId){
        TreinoInputDTO treino = treinoService.obterTreinoPorId(pId);
        return ResponseEntity.ok().body(treino);
    }

    @GetMapping
    public ResponseEntity<List<TreinoInputDTO>> listarTodos() {
        List<TreinoInputDTO> treinos = treinoService.obterTodosOsTreinos();
        return ResponseEntity.ok().body(treinos);
    }

    @PostMapping
    public ResponseEntity<TreinoInputDTO> adicionarTreino(@Valid @RequestBody TreinoInputDTO Input) {
        TreinoInputDTO novoTreino = treinoService.adicionarTreino(Input);
        return ResponseEntity.status(201).body(novoTreino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoInputDTO> atualizarTreino(@Valid @RequestBody TreinoInputDTO Input) {
        treinoService.atualizarTreino(Input);
        return ResponseEntity.ok().body(Input);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTreino(@PathVariable Integer id) {
        treinoService.removerTreino(id);
        return ResponseEntity.noContent().build();
    }


    /*
     * ===================================================================================
     * Demais funções
     * ===================================================================================
     * */
}
