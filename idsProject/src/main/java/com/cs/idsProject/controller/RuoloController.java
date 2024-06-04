package com.cs.idsProject.controller;

import com.cs.idsProject.entity.Ruolo;
import com.cs.idsProject.service.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ruoli")
public class RuoloController {

    @Autowired
    private RuoloService ruoloService;

    @GetMapping
    public List<Ruolo> getAllRuoli() {
        return ruoloService.getAllRuoli();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruolo> getRuoloById(@PathVariable int id) {
        Optional<Ruolo> ruolo = ruoloService.getRuoloById(id);
        return ruolo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ruolo createRuolo(@RequestBody Ruolo ruolo) {
        return ruoloService.addRuolo(ruolo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuolo(@PathVariable int id) {
        if (ruoloService.getRuoloById(id).isPresent()) {
            ruoloService.deleteRuolo(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
