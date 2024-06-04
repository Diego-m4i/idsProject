package com.cs.idsProject.controller;

import com.cs.idsProject.service.ComuneService;
import com.cs.idsProject.entity.Comune;
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
        if (comune.isPresent()) {
            return ResponseEntity.ok(comune.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Comune addComune(@RequestBody Comune comune) {
        return comuneService.addComune(comune);
    }

    @DeleteMapping("/{id}")
    public void deleteComune(@PathVariable int id) {
        comuneService.deleteComune(id);
    }
}
