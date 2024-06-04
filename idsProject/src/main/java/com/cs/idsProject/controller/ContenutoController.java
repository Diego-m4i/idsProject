package com.cs.idsProject.controller;

import com.cs.idsProject.entity.Contenuto;
import com.cs.idsProject.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contenuti")
public class ContenutoController {
    @Autowired
    private ContenutoService contenutoService;

    @GetMapping
    public List<Contenuto> getAllContenuti() {
        return contenutoService.getAllContenuti();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenuto> getContenutoById(@PathVariable int id) {
        Optional<Contenuto> contenuto = contenutoService.getContenutoById(id);
        if (contenuto.isPresent()) {
            return ResponseEntity.ok(contenuto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Contenuto addContenuto(@RequestBody Contenuto contenuto) {
        return contenutoService.addContenuto(contenuto);
    }

    @DeleteMapping("/{id}")
    public void deleteContenuto(@PathVariable int id) {
        contenutoService.deleteContenuto(id);
    }
}
