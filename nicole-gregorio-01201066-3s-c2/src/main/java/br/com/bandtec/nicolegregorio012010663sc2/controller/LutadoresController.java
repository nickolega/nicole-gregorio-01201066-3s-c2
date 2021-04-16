package br.com.bandtec.nicolegregorio012010663sc2.controller;

import br.com.bandtec.nicolegregorio012010663sc2.dominio.Lutadores;
import br.com.bandtec.nicolegregorio012010663sc2.repositorio.LutadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadoresController {

    @Autowired
    private LutadoresRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody Lutadores novoLutador) {
        if (novoLutador.getNome().length() < 3 || novoLutador.getNome().length() > 12) {
            return ResponseEntity.status(400).body("O nome deve conter no mínimo 3 caracteres e no máximo 12");
        }

        if (novoLutador.getForcaGolpe() < 0) {
            return ResponseEntity.status(400).body("O valor da força do golpe deve ser maior ou igual a 0");
        }

        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutadores() {
        List<Lutadores> lutadores = repository.findAll();

        if (lutadores.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(lutadores);
        }
    }
}
