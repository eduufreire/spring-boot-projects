package school.sptech.jogadoresfutebol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.sptech.jogadoresfutebol.model.dto.DadosAtualizarJogadorDTO;
import school.sptech.jogadoresfutebol.model.dto.DadosCadastroJogadorDTO;
import school.sptech.jogadoresfutebol.model.enumerates.Posicao;

@Entity
@Table(name = "jogadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;
    private Double altura;
    private Integer jogos;
    private Integer gols;
    private Integer assistencia;
    private Double valorMercado;


    public JogadorModel(DadosCadastroJogadorDTO dados){
        this.nome = dados.nome();
        this.posicao = dados.posicao();
        this.altura = dados.altura();
        this.jogos = dados.jogos();
        this.gols = dados.gols();
        this.assistencia = dados.assistencia();
        this.valorMercado = dados.valorMercado();
    }

    public void atualizarDados(DadosAtualizarJogadorDTO dados){

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.jogos() != null){
            this.jogos = dados.jogos();
        }

        if(dados.gols() != null){
            this.gols = dados.gols();
        }

        if(dados.assistencia() != null){
            this.assistencia = dados.assistencia();
        }

        if(dados.valorMercado() != null){
            this.valorMercado = dados.valorMercado();
        }

    }

}
