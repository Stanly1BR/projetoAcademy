package br.com.academy.rest.controller;

import br.com.academy.rest.dto.Historico_TreinoInputDTO;
import br.com.academy.service.Historico_TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HistoricoTreino")
public class Historico_TreinoController {

    @Autowired
    private Historico_TreinoService historicoTreinoService;

    /*
     * CRUD Padrão e funcionalidades relacionadas ao histórico de treinos
     */

    @GetMapping("/{pId}")
    public ResponseEntity<Historico_TreinoInputDTO> obterPorId(@PathVariable int pId){
        Historico_TreinoInputDTO historico = historicoTreinoService.buscarPorId(pId);
        return ResponseEntity.ok().body(historico);
    }

    @GetMapping
    public ResponseEntity<List<Historico_TreinoInputDTO>> listartodos(){
        List<Historico_TreinoInputDTO> historicolist = historicoTreinoService.buscarTodos();
        return ResponseEntity.ok().body(historicolist);
    }

    @PostMapping
    public ResponseEntity<Historico_TreinoInputDTO> adicionarHistoricoTreino(@Valid @RequestBody Historico_TreinoInputDTO input){
        return ResponseEntity.ok().body(historicoTreinoService.adicionarHistoricoTreino(input));
    }

    @PutMapping
    public ResponseEntity<Historico_TreinoInputDTO> atualizarHistoricoTreino(@Valid @RequestBody Historico_TreinoInputDTO input){
        return ResponseEntity.ok().body(historicoTreinoService.atualizarHistoricoTreino(input));
    }

    @DeleteMapping
    public ResponseEntity<Void> removerHistoricoTreino(@RequestBody int id){
        historicoTreinoService.removerHistoricoTreino(id);
        return ResponseEntity.noContent().build();
    }
}
