package com.primeiroprojeto.eduardo.curso.controllers;

import com.primeiroprojeto.eduardo.curso.remedio.Remedio;
import com.primeiroprojeto.eduardo.curso.remedio.Via;

import java.time.LocalDate;

public record DadosListagemRemedio(
        Long id,
        String nome,
        Via via,
        LocalDate validade,
        String lote
) {

    public DadosListagemRemedio(Remedio remedio){
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getValidade(), remedio.getLote());
    }

}
