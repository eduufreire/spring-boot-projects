package com.primeiroprojeto.eduardo.curso.controllers;

import com.primeiroprojeto.eduardo.curso.remedio.DadosAtualizarRemedio;
import com.primeiroprojeto.eduardo.curso.remedio.Remedio;
import com.primeiroprojeto.eduardo.curso.remedio.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.primeiroprojeto.eduardo.curso.remedio.DadosCadastroRemedio;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @GetMapping
    public List<DadosListagemRemedio> listarRemedios(){
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }


    // PostMapping é quando um método serve para enviar dados.
    // o RequestBody indica de onde vem o valor pedido no parametro
    @PostMapping
    @Transactional
    public void cadastrarRemedio(@RequestBody @Valid DadosCadastroRemedio dadosCadastroRemedio){
        repository.save(new Remedio(dadosCadastroRemedio));
    }

    @PutMapping
    @Transactional // caso dê problema na hora da requisição, essa anotação recupera os dados
    public void atualizarRemedio(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarRemedio(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }





}
