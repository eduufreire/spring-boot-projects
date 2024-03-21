package com.example.demo.service;

import com.example.demo.model.Mensagem;
import com.example.demo.model.PessoaModel;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private PessoaRepository action;


    // Método para cadastrar pessoas
    public ResponseEntity<?> cadastrar(PessoaModel dados){

        if(dados.getNome().equals("")){
            mensagem.setMensagem("Nome inválido");
            return ResponseEntity.status(400).body(mensagem);

        }else if(dados.getIdade() < 0){
            mensagem.setMensagem("Idade inválida");
            return ResponseEntity.status(400).body(mensagem);

        }else{
            return ResponseEntity.status(201).body(action.save(dados));
        }

    }


    // Método para selecionar pessoas
    public ResponseEntity<List<PessoaModel>> selecionar(){

        List<PessoaModel> listaPessoas = action.findAll();

        if(!listaPessoas.isEmpty()){
            return ResponseEntity.status(200).body(listaPessoas);
        }
        return ResponseEntity.status(204).build();

    }


    // Método para selecionar uma pessoa por código
    public ResponseEntity<PessoaModel> selecionarPorCodigo(int codigo){

        PessoaModel pessoaModel = action.findById(codigo);

        if(!Objects.isNull(pessoaModel))
        {
            return ResponseEntity.status(200).body(pessoaModel);
        }
        return ResponseEntity.status(404).build();

    }


    // Método para ordernar a lista pelo nome
    public ResponseEntity<List<PessoaModel>> ordenarPorNome(){

        List<PessoaModel> listaPessoa = action.findByOrderByNome();

        if(!Objects.isNull(listaPessoa))
        {
            return ResponseEntity.status(200).body(listaPessoa);
        }
        return ResponseEntity.status(204).build();

    }


    // Método para editar uma pessoa
    public ResponseEntity<?> editar(PessoaModel dadosPessoa) {

        int existeRegistroPessoa = action.countById(dadosPessoa.getId());

        if(existeRegistroPessoa == 0){
            mensagem.setMensagem("id invalid");
            return ResponseEntity.status(404).body(mensagem);

        } else if(dadosPessoa.getNome().equals("")){
            mensagem.setMensagem("name invalid");
            return ResponseEntity.status(400).body(mensagem);

        } else if(dadosPessoa.getIdade() < 0){
            mensagem.setMensagem("age invalid");
            return ResponseEntity.status(400).body(mensagem);

        }

        return ResponseEntity.status(200).body(action.save(dadosPessoa));

    }


}
