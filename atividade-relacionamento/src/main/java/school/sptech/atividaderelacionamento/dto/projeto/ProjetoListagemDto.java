package school.sptech.atividaderelacionamento.dto.projeto;

import jakarta.persistence.OneToMany;
import lombok.Data;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjetoListagemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<TarefaListagemDTO> tarefas;

    @Data
    public static class TarefaListagemDTO {
        private Integer id;
        private String nome;
        private String descricao;
        private boolean concluida;
        private String prioridade;
    }

}

