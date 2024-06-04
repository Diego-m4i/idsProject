package com.cs.idsProject.controller;


import com.cs.idsProject.service.UtenteService;
import com.cs.idsProject.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> getAllUsers() {
        return utenteService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUserById(@PathVariable int id) {
        Optional<Utente> utente = utenteService.getUserById(id);
        if (utente.isPresent()) {
            return ResponseEntity.ok(utente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Utente addUser(@RequestBody Utente utente) {
        return utenteService.addUser(utente);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        utenteService.deleteUser(id);
    }
}
