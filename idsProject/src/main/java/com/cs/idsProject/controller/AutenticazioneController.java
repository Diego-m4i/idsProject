package com.cs.idsProject.controller;

import com.cs.idsProject.entity.Utente;
import com.cs.idsProject.service.ServizioAutenticazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AutenticazioneController {

    @Autowired
    private ServizioAutenticazione servizioAutenticazione;

    public AutenticazioneController(ServizioAutenticazione servizioAutenticazione) {
        this.servizioAutenticazione = servizioAutenticazione;
    }
    @PostMapping("/login")
    public ResponseEntity<Utente> login(@RequestParam String username, @RequestParam String password) {
        Optional<Utente> utente = servizioAutenticazione.autenticazione(username, password);
        if (utente.isPresent()) {
            return ResponseEntity.ok(utente.get());
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Utente> register(@RequestBody Utente utente) {
        try {
            Utente nuovoUtente = servizioAutenticazione.registrazione(utente);
            return ResponseEntity.ok(nuovoUtente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Bad Request
        }
    }
}
