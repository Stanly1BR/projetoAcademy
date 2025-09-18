package br.com.academy.rest.controller;

import br.com.academy.rest.dto.Bloco_ExercicioInputDTO;
import br.com.academy.service.Bloco_ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BlocoExercicio")
public class Bloco_ExercicioController {

    @Autowired
    private Bloco_ExercicioService blocoExercicioService;

    /*
     * CRUD Padrão (Buscar, Listar todos, Salvar, Atualizar e Deletar)
     */

    @GetMapping("/{id}")
    public ResponseEntity<Bloco_ExercicioInputDTO> buscarPorId(@PathVariable Integer id) {
        Bloco_ExercicioInputDTO blocoExercicio = blocoExercicioService.obterPorId(id);
        return ResponseEntity.ok().body(blocoExercicio);
    }

    @GetMapping
    public ResponseEntity<List<Bloco_ExercicioInputDTO>> listarTodos() {
        List<Bloco_ExercicioInputDTO> blocosExercicios = blocoExercicioService.obterTodosOsBlocosExercicios();
        return ResponseEntity.ok().body(blocosExercicios);
    }

    @PostMapping
    public ResponseEntity<Bloco_ExercicioInputDTO> adicionar(@Valid @RequestBody Bloco_ExercicioInputDTO Input) {
        Bloco_ExercicioInputDTO novo = blocoExercicioService.adicionarBlocoExercicio(Input);
        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloco_ExercicioInputDTO> atualizar(@Valid @RequestBody Bloco_ExercicioInputDTO Input) {
        Bloco_ExercicioInputDTO atualizado = blocoExercicioService.atualizarBlocoExercicio(Input);
        return ResponseEntity.ok().body(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        blocoExercicioService.removerBlocoExercicio(id);
        return ResponseEntity.noContent().build();
    }
}
