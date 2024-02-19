package school.sptech.jogadoresfutebol.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.sptech.jogadoresfutebol.model.JogadorModel;
import school.sptech.jogadoresfutebol.model.dto.DadosAtualizarJogadorDTO;
import school.sptech.jogadoresfutebol.model.dto.DadosCadastroJogadorDTO;
import school.sptech.jogadoresfutebol.repository.JogadorRepository;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository actionRepository;

    @GetMapping
    public List<JogadorModel> getAllJogadores(){
        return actionRepository.findAll();
    }

    @GetMapping("/{id}")
    public JogadorModel getIdJogador(@PathVariable int id){
        return actionRepository.findById(id);
    }

    @PostMapping
    @Transactional
    public JogadorModel insertJogador(@RequestBody @Valid DadosCadastroJogadorDTO dados){
       return actionRepository.save(new JogadorModel(dados));
    }

    @PutMapping
    @Transactional
    public void updateJogador(@RequestBody @Valid DadosAtualizarJogadorDTO dados){
        var jogador = actionRepository.getReferenceById(dados.id());
        jogador.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    public void deleteJogador(@PathVariable Long id){
        actionRepository.deleteById(id);
    }


}
