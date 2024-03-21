package com.example.projeto03statushttp;

public class Produto {

    private String nome;
    private double preco;
    private int qtdEstoque;

    private double valorTotalEstoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorTotalEstoque() {
        return qtdEstoque * preco;
    }

}
