package com.cs.idsProject.service;

import com.cs.idsProject.entity.Preferito;
import com.cs.idsProject.entity.Utente;
import com.cs.idsProject.entity.Contenuto;
import com.cs.idsProject.repository.PreferitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferitoService {

    @Autowired
    private PreferitoRepository preferitoRepository;

    public Preferito aggiungiPreferito(Utente utente, Contenuto contenuto) {
        Preferito preferito = new Preferito(utente.getId(), contenuto);
        return preferitoRepository.save(preferito);
    }

    public void rimuoviPreferito(Integer id) {
        preferitoRepository.deleteById(id);
    }

    public List<Preferito> ottieniPreferitiPerUtente(Utente utente) {
        return preferitoRepository.findByUtente(utente);
    }
}
