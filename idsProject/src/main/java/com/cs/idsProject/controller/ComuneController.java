package com.cs.idsProject.controller;

import com.cs.idsProject.entity.Comune;
import com.cs.idsProject.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comuni")
public class ComuneController {

    @Autowired
    private ComuneService comuneService;

    @GetMapping
    public List<Comune> getAllComuni() {
        return comuneService.getAllComuni();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comune> getComuneById(@PathVariable int id) {
        Optional<Comune> comune = comuneService.getComuneById(id);
        return comune.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comune> addComune(@RequestBody Comune comune) {
        Comune savedComune = comuneService.addComune(comune);
        return ResponseEntity.ok(savedComune);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComune(@PathVariable Integer id) {
        Optional<Comune> comune = comuneService.getComuneById(id);
        if (comune.isPresent()) {
            comuneService.deleteComune(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
