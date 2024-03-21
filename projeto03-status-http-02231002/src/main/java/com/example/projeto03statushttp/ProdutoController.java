package com.example.projeto03statushttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> listaProdutos = new ArrayList<>();


    // Endpoint para listar todos os produtos cadastrados
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        if(!listaProdutos.isEmpty()){
            return ResponseEntity.status(200).body(listaProdutos);
        }
        return ResponseEntity.status(204).build();
    }

    // Endpoint para retorna os produtos com a quantidade >= que o parâmetro passado
    @GetMapping("/estoque")
    public ResponseEntity<List<Produto>> quantidadeMaiorIgual(
            @RequestParam int qtdEstoque
    ){

        List<Produto> novaListaProdutos = listaProdutos
                .stream()
                .filter(produtoAtual ->
                        produtoAtual.getQtdEstoque() >= qtdEstoque)
                .toList();

        if(novaListaProdutos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(novaListaProdutos);

    }


    // Endpoint para cadastrar um produto
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto dadosProduto
    ){

        if(!Objects.isNull(dadosProduto)){
            listaProdutos.add(dadosProduto);
            return ResponseEntity.status(201).body(dadosProduto);
        }
        return ResponseEntity.status(400).build();

    }


    // Endpoint para alterar um produto
    @PutMapping("/{indice}")
    public ResponseEntity<Produto> alterarProduto(
            @PathVariable int indice,
            @RequestBody Produto dadosProduto
    ){

        if(indice >= 0 && indice < listaProdutos.size()){
            if(!Objects.isNull(dadosProduto)){
                listaProdutos.set(indice, dadosProduto);
                return ResponseEntity.status(200).body(dadosProduto);
            }
        }
        return ResponseEntity.status(404).build();

    }


    @GetMapping("/busca-por-nome")
    public ResponseEntity<List<Produto>> buscaPorNome(
            @RequestHeader("token") String token,
            @RequestParam String nome
    ){

        System.out.println(token);

        List<Produto> listaFiltrada = listaProdutos
                .stream()
                .filter(produto -> produto.getNome().contains(nome))
                .toList();

        if(listaFiltrada.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaFiltrada);

    }







}
