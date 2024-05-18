package school.sptech.atividaderelacionamento.dto.projeto;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Data;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjetoCriacaoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @FutureOrPresent
    @NotNull
    private LocalDate dataInicio;

    @Future
    @NotNull
    private LocalDate dataFim;

}
