package com.primeiroprojeto.eduardo.curso.remedio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Remedios") // Indica que essa classe será uma entidade do banco de dados
@Table(name = "Remedio") // Será representando numa tabela chamado "Remedio" dentro do banco de dados
// Cria os getters and setters e tempo de compilação
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id // Indica que será o id (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identifica que a criacao desse id é automatico
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING) //
    private Via via;
    private String lote;
    private Integer quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public Remedio(DadosCadastroRemedio dados){
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }


    public void atualizarRemedio(DadosAtualizarRemedio dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.via() != null){
            this.via = dados.via();
        }

        if(dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
    }
}
