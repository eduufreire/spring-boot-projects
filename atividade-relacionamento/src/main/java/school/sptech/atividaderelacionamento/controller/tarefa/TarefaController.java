package school.sptech.atividaderelacionamento.controller.tarefa;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaCriacaoDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaListagemDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;
import school.sptech.atividaderelacionamento.service.tarefa.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaListagemDto>> listarTarefas() {
        List<Tarefa> tarefas = service.listarTarefas();
        if(tarefas.isEmpty()) return ResponseEntity.noContent().build();

        List<TarefaListagemDto> tarefasDTO = TarefaMapper.toDto(tarefas);
        return ResponseEntity.ok(tarefasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaListagemDto> buscarTarefa(
            @PathVariable Integer id
    ) {
        Tarefa tarefa = service.buscarTarefaPorId(id);
        return ResponseEntity.ok(TarefaMapper.toDto(tarefa));
    }

    @PostMapping
    public ResponseEntity<TarefaListagemDto> criarTarefa(
            @RequestBody @Valid TarefaCriacaoDto tarefaCriacaoDto
    ) {
        Tarefa novaTarefa = TarefaMapper.toEntity(tarefaCriacaoDto);
        Tarefa tarefaSalva = service.salvarTarefa(novaTarefa, tarefaCriacaoDto.getProjetoId());
        return ResponseEntity.created(null).body(TarefaMapper.toDto(tarefaSalva));
    }
}
