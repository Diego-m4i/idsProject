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

    public POI addPunto(POI punto) {
        return puntoRepository.save(punto);
    }

    public void deletePunto(int id) {
        puntoRepository.deleteById(id);
    }
}
