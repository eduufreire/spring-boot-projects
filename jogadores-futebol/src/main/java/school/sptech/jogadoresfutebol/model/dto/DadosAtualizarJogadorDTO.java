package school.sptech.jogadoresfutebol.model.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarJogadorDTO(
        @NotNull
        Long id,
        String nome,
        Integer jogos,
        Integer gols,
        Integer assistencia,
        Double valorMercado

) {
}
