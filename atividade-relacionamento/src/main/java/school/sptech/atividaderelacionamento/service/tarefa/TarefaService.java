package school.sptech.atividaderelacionamento.service.tarefa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.atividaderelacionamento.repository.tarefa.TarefaRepository;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;
    private final ProjetoService serviceProjeto;

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa buscarTarefaPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Tarefa")
        );
    }

    public Tarefa salvarTarefa(Tarefa tarefa, Integer idProjeto) {
        Projeto projetoPorId = serviceProjeto.buscarProjetoPorId(idProjeto);
        tarefa.setProjeto(projetoPorId);
        return repository.save(tarefa);
    }

}
