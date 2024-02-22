package com.example.demo.controllers;

import com.example.demo.model.PessoaModel;
import com.example.demo.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository action;

    @GetMapping
    public List<PessoaModel> listar(){
        return action.findAll();
    }

    @GetMapping("/{id}")
    public PessoaModel buscarPorID(@PathVariable int id){
        return action.findById(id);
    }

    @GetMapping("/teste/{nome}")
    public PessoaModel buscarPorNOME(@PathVariable String nome){
        return action.findByNome(nome);
    }

    @GetMapping("/count")
    public long contar(){
        return action.count();
    }

    @GetMapping("/orderBy-name")
    public List<PessoaModel> ordernarPorNome(){
        return action.findByOrderByNome();
    }

    @GetMapping("/exemple-orderBy-name")
    public List<PessoaModel> filtrarPorNomeEOrdenar(){
        return action.findByNomeOrderByIdade("Eduardo");
    }

    @GetMapping("orderBy-age")
    public List<PessoaModel> ordenarPorIdade(){
        return action.findByOrderByIdade();
    }


    @PostMapping
    @Transactional
    public PessoaModel cadastrar(@RequestBody PessoaModel p){
        return action.save(p);
    }

    @PutMapping
    @Transactional
    public PessoaModel editar(@RequestBody PessoaModel dadosPessoa){
        return action.save(dadosPessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        PessoaModel pessoa = action.findById(id);
        action.delete(pessoa);
    }


}
