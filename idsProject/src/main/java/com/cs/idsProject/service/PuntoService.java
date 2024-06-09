package com.cs.idsProject.service;

import com.cs.idsProject.entity.POI;
import com.cs.idsProject.repository.PuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntoService {

    @Autowired
    private PuntoRepository puntoRepository;


    public List<POI> getAllPunti() {
        return puntoRepository.findAll();
    }

    public Optional<POI> getPuntoById(Integer id) {
        return puntoRepository.findById(id);
    }

    public POI addPunto(Integer idComune, POI punto) {
        // Verifica se il punto esiste già per lo stesso comune
        Optional<POI> existingPunto = puntoRepository.findByNomeAndLatitudineAndLongitudineAndIdComune(
                punto.getNome(), punto.getLatitudine(), punto.getLongitudine(), idComune);

        if (existingPunto.isPresent()) {
            throw new IllegalArgumentException("Il punto con lo stesso nome e coordinate esiste già nel comune specificato.");
        }

        punto.setIdComune(idComune);
        return puntoRepository.save(punto);
    }

    public void deletePunto(Integer id, Integer idComune) {
        // Verifica se il punto esiste nel repository per lo stesso comune
        Optional<POI> existingPunto = puntoRepository.findByIdAndIdComune(id, idComune);

        if (existingPunto.isPresent()) {
            puntoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Il punto con l'ID e il comune forniti non esiste.");
        }
    }
}
