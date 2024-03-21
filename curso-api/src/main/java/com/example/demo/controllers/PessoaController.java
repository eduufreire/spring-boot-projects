package com.example.demo.controllers;

import com.example.demo.model.PessoaModel;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.Servico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository action;

    @Autowired
    private Servico servico;


    @GetMapping
    public ResponseEntity<List<PessoaModel>> listar(){
        return servico.selecionar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> buscarPorID(@PathVariable int id){
        return servico.selecionarPorCodigo(id);
    }

    @GetMapping("/count")
    public long contar(){
        return action.count();
    }

    @GetMapping("/orderBy-name")
    public ResponseEntity<List<PessoaModel>> ordernarPorNome(){
        return servico.ordenarPorNome();
    }

    @GetMapping("/exemple-orderBy-name")
    public List<PessoaModel> filtrarPorNomeEOrdenar(){
        return action.findByNomeOrderByIdade("Eduardo");
    }

    @GetMapping("/nome-contem/{nome}")
    public List<PessoaModel> nomeContem(@PathVariable String nome){
        return action.findByNomeContaining(nome);
    }

    @GetMapping("/nome-inicia/{nome}")
    public List<PessoaModel> iniciaCom(@PathVariable String nome){
        return action.findByNomeStartsWith(nome);
    }

    @GetMapping("/nome-termina/{nome}")
    public List<PessoaModel> terminaCom(@PathVariable String nome){
        return action.findByNomeEndsWith(nome);
    }

    @GetMapping("orderBy-age")
    public List<PessoaModel> ordenarPorIdade(){
        return action.findByOrderByIdade();
    }

    @GetMapping("/soma-idades")
    public int somaIdades(){
        return action.somaIdades();
    }

    @GetMapping("/idade-maior/{idade}")
    public List<PessoaModel> idadeMaior(@PathVariable int idade){
        return action.idadeMaiorIgual(idade);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody PessoaModel p){

        return servico.cadastrar(p);

    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> editar(@RequestBody PessoaModel dadosPessoa){
        return servico.editar(dadosPessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        PessoaModel pessoa = action.findById(id);
        action.delete(pessoa);
    }


}
