package com.example.demo.repository;

import com.example.demo.model.PessoaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaModel, Integer> {

    // Ensinando o repostório a retornar uma lista de pessoas
    // fazendo a sobreescrita do método findAll
    List<PessoaModel> findAll();

    PessoaModel findById(int id);

    PessoaModel findByNome(String nome);

    List<PessoaModel> findByOrderByNome();

    List<PessoaModel> findByOrderByIdade();

    List<PessoaModel> findByNomeOrderByIdade(String nome);
}
