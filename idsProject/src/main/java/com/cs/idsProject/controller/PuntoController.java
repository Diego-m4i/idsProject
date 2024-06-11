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
        return punto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{idComune}")
    public ResponseEntity<POI> addPunto(@PathVariable Integer idComune, @RequestBody POI punto) {
        try {
            POI savedPunto = puntoService.addPunto(idComune, punto);
            return ResponseEntity.ok(savedPunto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
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
