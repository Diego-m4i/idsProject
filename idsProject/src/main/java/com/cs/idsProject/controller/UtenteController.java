package com.cs.idsProject.controller;

import com.cs.idsProject.entity.Utente;
import com.cs.idsProject.service.UtenteService;
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
    public List<Utente> getAllUtenti() {
        return utenteService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Integer id) {
        Optional<Utente> utente = utenteService.getUserById(id);
        return utente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Utente> addUtente(@RequestBody Utente utente) {
        try {
            Utente savedUtente = utenteService.addUser(utente);
            return ResponseEntity.ok(savedUtente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUtente(@PathVariable Integer id) {
        try {
            utenteService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{userId}/ruoli/{roleId}")
    public ResponseEntity<Utente> assignRoleToUtente(@PathVariable Integer userId, @PathVariable Integer roleId) {
        try {
            Utente updatedUtente = utenteService.assignRole(userId, roleId);
            return ResponseEntity.ok(updatedUtente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
