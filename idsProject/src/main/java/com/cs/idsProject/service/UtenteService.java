package com.cs.idsProject.service;

import com.cs.idsProject.entity.Ruolo;
import com.cs.idsProject.entity.Utente;
import com.cs.idsProject.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private RuoloService ruoloService;

    public Utente assignRole(Integer userId, Integer roleId) {
        // Controllo se l'utente esiste
        Optional<Utente> utenteOptional = utenteRepository.findById(userId);
        if (utenteOptional.isPresent()) {
            // L'utente esiste, controllo se il ruolo esiste
            Optional<Ruolo> ruoloOptional = ruoloService.getRuoloById(roleId);
            if (ruoloOptional.isPresent()) {
                // Il ruolo esiste
                Utente utente = utenteOptional.get();
                Ruolo ruolo = ruoloOptional.get();
                utente.addRuolo(ruolo);
                return utenteRepository.save(utente);
            } else {
                // Il ruolo non esiste
                throw new RuntimeException("Il ruolo specificato non esiste");
            }
        } else {
            // L'utente non esiste
            throw new RuntimeException("L'utente specificato non esiste");
        }
    }


    public List<Utente> getAllUser() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUserById(Integer id) {
        return this.utenteRepository.findById(id);
    }

    public Utente addUser(Utente utente) {
        // Controllo se l'utente esiste già
        Optional<Utente> existingUtente = utenteRepository.findByUsername(utente.getUsername());
        if (existingUtente.isPresent()) {
            // L'utente esiste già, gestire di conseguenza (eccezione, aggiornamento, ecc.)
            // Ecco un esempio di lancio di un'eccezione:
            throw new RuntimeException("L'utente esiste già");
        } else {
            // L'utente non esiste, quindi lo salviamo
            return utenteRepository.save(utente);
        }
    }

    public void deleteUser(Integer id) {
        // Controllo se l'utente esiste prima di eliminarlo
        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
        } else {
            // L'utente non esiste, potresti lanciare un'eccezione o gestirlo diversamente
            throw new RuntimeException("Utente non trovato");
        }
    }
}
