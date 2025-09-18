package br.com.academy.rest.controller;

import br.com.academy.rest.dto.Historico_ExercicioInputDTO;
import br.com.academy.service.Historico_ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HistoricoExercicio")
public class Historico_ExercicioController {

    @Autowired
    private Historico_ExercicioService historicoExercicioService;

    /*
     * CRUD Padrão (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     */

    @GetMapping("/{pId}")
    public ResponseEntity<Historico_ExercicioInputDTO> obterPorId(@PathVariable int pId) {
        Historico_ExercicioInputDTO HistoricoExercicio = historicoExercicioService.obterHistoricoExercicioPorId(pId);
        return ResponseEntity.ok().body(HistoricoExercicio);
    }

    @GetMapping
    public ResponseEntity<List<Historico_ExercicioInputDTO>> obterTodosOsHistoricoExercicios() {
        List<Historico_ExercicioInputDTO> ListaHistoricoExercicios = historicoExercicioService.obterTodosOsHistoricoExercicios();
        return ResponseEntity.ok().body(ListaHistoricoExercicios);
    }

    @PostMapping
    public ResponseEntity<Historico_ExercicioInputDTO> adicionarHistoricoExercicio(@Valid @RequestBody Historico_ExercicioInputDTO input) {
        return ResponseEntity.ok().body(historicoExercicioService.adicionarHistoricoExercicio(input));
    }

    @PutMapping
    public ResponseEntity<Historico_ExercicioInputDTO> atualizarHistoricoExercicio(@Valid @RequestBody Historico_ExercicioInputDTO input) {
        return ResponseEntity.ok().body(historicoExercicioService.alterarrHistoricoExercicio(input));
    }

    @DeleteMapping("/{pId}")
    public ResponseEntity<Void> deletar(@PathVariable int pId) {
        historicoExercicioService.deletarHistoricoExercicio(pId);
        return ResponseEntity.ok().build();
    }
}