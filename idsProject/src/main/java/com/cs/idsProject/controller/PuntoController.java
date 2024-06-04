package com.cs.idsProject.controller;

import com.cs.idsProject.entity.POI;
import com.cs.idsProject.service.PuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/poi")
public class PuntoController {
    @Autowired
    private PuntoService puntoService;

    @GetMapping
    public List<POI> getAllPunti() {
        return puntoService.getAllPunti();
    }

    @GetMapping("/{id}")
    public ResponseEntity<POI> getPuntoById(@PathVariable int id) {
        Optional<POI> punto = puntoService.getPuntoById(id);
        if (punto.isPresent()) {
            return ResponseEntity.ok(punto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public POI addPunto(@RequestBody POI punto) {
        return puntoService.addPunto(punto);
    }

    @DeleteMapping("/{id}")
    public void deletePunto(@PathVariable int id) {
        puntoService.deletePunto(id);
    }
}
