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
        return contenuto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contenuto> addContenuto(@RequestBody Contenuto contenuto,
                                                  @RequestParam Integer idComune,
                                                  @RequestParam Integer idPunto) {
        Contenuto savedContenuto = contenutoService.addContenuto(contenuto, idComune, idPunto);
        return ResponseEntity.ok(savedContenuto);
    }

    @DeleteMapping("/{idContenuto}")
    public ResponseEntity<Void> deleteContenuto(@PathVariable Integer idContenuto,
                                                @RequestParam Integer idComune,
                                                @RequestParam Integer idPunto) {
        Optional<Contenuto> contenuto = contenutoService.getContenutoById(idContenuto);
        if (contenuto.isPresent()) {
            contenutoService.deleteContenuto(idContenuto, idComune, idPunto);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
