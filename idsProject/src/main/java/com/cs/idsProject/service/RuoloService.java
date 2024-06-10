package com.cs.idsProject.service;

import com.cs.idsProject.entity.Ruolo;
import com.cs.idsProject.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    public List<Ruolo> getAllRuoli() {
        return ruoloRepository.findAll();
    }

    public Optional<Ruolo> getRuoloById(Integer id) {
        return ruoloRepository.findById(id);
    }

    public Ruolo addRuolo(Ruolo ruolo) {
        return ruoloRepository.save(ruolo);
    }

    public void deleteRuolo(Integer id) {
        ruoloRepository.deleteById(id);
    }
}
