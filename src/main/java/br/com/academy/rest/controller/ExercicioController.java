package br.com.academy.rest.controller;

import br.com.academy.rest.dto.ExercicioInputDTO;
import br.com.academy.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    /*
     * CRUD Padrão (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     */

    @GetMapping("/{pId}")
    public ResponseEntity<ExercicioInputDTO> buscarPorId(@PathVariable Integer pId) {
        ExercicioInputDTO exercicio = exercicioService.obterPorId(pId);
        return ResponseEntity.ok().body(exercicio);
    }

    @GetMapping
    public ResponseEntity<List<ExercicioInputDTO>> listarTodos() {
        List<ExercicioInputDTO> exercicios = exercicioService.obterTodosExercicios();
        return ResponseEntity.ok().body(exercicios);
    }

    @PostMapping
    public ResponseEntity<ExercicioInputDTO> adicionarExercicio(@Valid @RequestBody ExercicioInputDTO Input) {
        ExercicioInputDTO novoExercicio = exercicioService.adicionarExercicio(Input);
        return ResponseEntity.status(201).body(novoExercicio);
    }

    @PutMapping
    public ResponseEntity<ExercicioInputDTO> atualizarExercicio(@Valid @RequestBody ExercicioInputDTO Input) {
        ExercicioInputDTO exercicioAtualizado = exercicioService.atualizarExercicio(Input);
        return ResponseEntity.ok().body(exercicioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExercicio(@PathVariable Integer id) {
        exercicioService.removerExercicio(id);
        return ResponseEntity.noContent().build();
    }
}