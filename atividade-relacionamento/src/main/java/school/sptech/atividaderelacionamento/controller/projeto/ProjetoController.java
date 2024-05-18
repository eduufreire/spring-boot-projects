package school.sptech.atividaderelacionamento.controller.projeto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoCriacaoDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @GetMapping
    public ResponseEntity<List<ProjetoListagemDto>> listarProjetos() {
        List<Projeto> projetos = service.listarProjetos();
        if(projetos.isEmpty()) return ResponseEntity.noContent().build();

        List<ProjetoListagemDto> projetoListagemDTO = ProjetoMapper.toDto(projetos);
        return ResponseEntity.ok(projetoListagemDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoListagemDto> buscarProjeto(
            @PathVariable Integer id
    ) {
        Projeto projeto = service.buscarProjetoPorId(id);
        return ResponseEntity.ok(ProjetoMapper.toDto(projeto));
    }

    @PostMapping
    public ResponseEntity<ProjetoListagemDto> criarProjeto(
            @RequestBody @Valid ProjetoCriacaoDto projetoCriacaoDto
    ) {
        Projeto novoProjeto = ProjetoMapper.toEntity(projetoCriacaoDto);
        Projeto projetoSalvo = service.salvarProjeto(novoProjeto);
        return ResponseEntity.created(null).body(ProjetoMapper.toDto(projetoSalvo));
    }
}
