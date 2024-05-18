package school.sptech.atividaderelacionamento.service.projeto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.atividaderelacionamento.repository.projeto.ProjetoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;

    public List<Projeto> listarProjetos() {
        return repository.findAll();
    }

    public Projeto buscarProjetoPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Projeto")
        );
    }

    public Projeto salvarProjeto(Projeto projeto) {
        LocalDate dataInicio = projeto.getDataInicio();
        LocalDate dataFim = projeto.getDataFim();
        if(dataInicio.isAfter(dataFim)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data Início inválida");
        }

        return repository.save(projeto);
    }
}
