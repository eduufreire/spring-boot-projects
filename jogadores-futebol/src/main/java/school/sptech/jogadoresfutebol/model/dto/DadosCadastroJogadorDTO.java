package school.sptech.jogadoresfutebol.model.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import school.sptech.jogadoresfutebol.model.enumerates.Posicao;

public record DadosCadastroJogadorDTO(
        @NotBlank
        String nome,
        @Enumerated
        Posicao posicao,
        @NotNull
        Double altura,
        @NotNull
        Integer jogos,
        @NotNull
        Integer gols,
        @NotNull
        Integer assistencia,
        @NotNull
        Double valorMercado
) {
}
