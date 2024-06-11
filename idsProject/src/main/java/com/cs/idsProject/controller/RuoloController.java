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
    public ResponseEntity<Ruolo> getRuoloById(@PathVariable Integer id) {
        Optional<Ruolo> ruolo = ruoloService.getRuoloById(id);
        return ruolo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ruolo> addRuolo(@RequestBody Ruolo ruolo) {
        Ruolo savedRuolo = ruoloService.addRuolo(ruolo);
        return ResponseEntity.ok(savedRuolo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuolo(@PathVariable Integer id) {
        Optional<Ruolo> ruolo = ruoloService.getRuoloById(id);
        if (ruolo.isPresent()) {
            ruoloService.deleteRuolo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
