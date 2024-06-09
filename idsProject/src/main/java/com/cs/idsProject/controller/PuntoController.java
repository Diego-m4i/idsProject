package com.cs.idsProject.controller;

import com.cs.idsProject.entity.POI;
import com.cs.idsProject.service.PuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/punti")
public class PuntoController {

    @Autowired
    private PuntoService puntoService;

    @GetMapping
    public List<POI> getAllPunti() {
        return puntoService.getAllPunti();
    }

    @GetMapping("/{id}")
    public ResponseEntity<POI> getPuntoById(@PathVariable Integer id) {
        Optional<POI> punto = puntoService.getPuntoById(id);
        return punto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{idComune}")
    public POI addPunto(@PathVariable Integer idComune, @RequestBody POI punto) {
        return puntoService.addPunto(idComune, punto);
    }

    @DeleteMapping("/{id}/{idComune}")
    public ResponseEntity<Void> deletePunto(@PathVariable Integer id, @PathVariable Integer idComune) {
        try {
            puntoService.deletePunto(id, idComune);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
