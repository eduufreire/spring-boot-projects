package com.example.demo.repository;

import com.example.demo.model.PessoaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaModel, Integer> {

    // Ensinando o repostório a retornar uma lista de pessoas
    // fazendo a sobreescrita do método findAll
    List<PessoaModel> findAll();

    PessoaModel findById(int id);

    Integer countById(Integer id);

    List<PessoaModel> findByOrderByNome();

    List<PessoaModel> findByOrderByIdade();

    List<PessoaModel> findByNomeOrderByIdade(String nome);

    List<PessoaModel> findByNomeContaining(String nome);

    List<PessoaModel> findByNomeStartsWith(String nome);

    List<PessoaModel> findByNomeEndsWith(String nome);

    @Query(value="select sum(idade) from pessoa", nativeQuery = true)
    int somaIdades();

    @Query(value = "select * from pessoa where idade >= :idade", nativeQuery = true)
    List<PessoaModel> idadeMaiorIgual(int idade);


}
