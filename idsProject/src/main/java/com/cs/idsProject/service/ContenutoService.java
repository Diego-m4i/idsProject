package com.cs.idsProject.service;


import com.cs.idsProject.entity.Contenuto;
import com.cs.idsProject.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenutoService {
    @Autowired
    private ContenutoRepository contenutoRepository;

    public List<Contenuto> getAllContenuti() {
        return contenutoRepository.findAll();
    }

    public Optional<Contenuto> getContenutoById(int id) {
        return contenutoRepository.findById(id);
    }

    public Contenuto addContenuto(Contenuto contenuto, Integer idComune, Integer idPunto) {
        return contenutoRepository.save(contenuto);
    }

    public void deleteContenuto(Integer idContenuto, Integer idComune, Integer idPunto) {
        contenutoRepository.deleteById(idContenuto);
    }
}
