package com.cs.idsProject.service;



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

    public List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUserById(int id) {
        return utenteRepository.findById(id);
    }

    public Utente addUser(Utente utente) {
        return utenteRepository.save(utente);
    }

    public boolean deleteUser(int id) {
        utenteRepository.deleteById(id);
    return true;
    }
}
