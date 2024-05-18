package school.sptech.atividaderelacionamento.dto.tarefa;

import lombok.Data;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;

import java.time.LocalDate;
import java.util.List;

@Data
public class TarefaListagemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private boolean concluida;
    private String prioridade;
    private ProjetoListagemDTO projeto;

    @Data
    public static class ProjetoListagemDTO {
        private Integer id;
        private String nome;
        private String descricao;
        private LocalDate dataInicio;
        private LocalDate dataFim;
    }

}
