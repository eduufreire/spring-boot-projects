package com.example.api2202;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.MacSpi;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    // jackson transforma os dados em formato json

    // singleton
    private List<Musica> musicas = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Musica>> listar(){
        if(musicas.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> recuperar(@PathVariable int id){
        if(existeMusica(id)){
            return ResponseEntity.status(200).body(musicas.get(id));
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Musica> cadastar(@RequestBody Musica dados) {
        musicas.add(dados);
        return ResponseEntity.status(201).body(dados);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Musica> atualizar(
            @PathVariable int indice,
            @RequestBody Musica musicaAtualizada,
    ){

        if(existeMusica(indice)){
            musicas.set(indice, musicaAtualizada);
            return ResponseEntity.status(201).body(musicaAtualizada);
        }
        return  ResponseEntity.status(404).body(musicaAtualizada);

    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice){
        if(existeMusica(indice)){
            musicas.remove(indice);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }


    public boolean existeMusica(int indice){
        return indice >= 0 && indice < musicas.size();
    }





}
