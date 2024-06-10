package com.cs.idsProject.service;

import com.cs.idsProject.entity.Utente;
import com.cs.idsProject.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class ServizioAutenticazione {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Optional<Utente> autenticazione(String username, String password) {
        Optional<Utente> utenteOpt = utenteRepository.findByUsername(username);
        if (utenteOpt.isPresent()) {
            Utente utente = utenteOpt.get();
            if (passwordEncoder.matches(password, utente.getPassword())) {
                return Optional.of(utente);
            }
        }
        return Optional.empty();
    }

    public Utente registrazione(Utente utente) {
        // Controllo se l'username è già in uso
        if (utenteRepository.findByUsername(utente.getUsername()).isPresent()) {
            throw new RuntimeException("Username già in uso");
        }
        // Cripta la password prima di salvare l'utente
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepository.save(utente);
    }
}
