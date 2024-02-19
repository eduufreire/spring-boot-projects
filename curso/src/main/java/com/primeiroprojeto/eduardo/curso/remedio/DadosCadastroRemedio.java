package com.primeiroprojeto.eduardo.curso.remedio;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroRemedio(
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        @NotNull
        Integer quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio
) {

}
