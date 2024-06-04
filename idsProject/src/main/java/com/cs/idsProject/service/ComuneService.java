package com.cs.idsProject.service;


import com.cs.idsProject.entity.Comune;
import com.cs.idsProject.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComuneService {
    @Autowired
    private ComuneRepository comuneRepository;

    public List<Comune> getAllComuni() {
        return comuneRepository.findAll();
    }

    public Optional<Comune> getComuneById(int id) {
        return comuneRepository.findById(id);
    }

    public Comune addComune(Comune comune) {
        return comuneRepository.save(comune);
    }

    public void deleteComune(int id) {
        comuneRepository.deleteById(id);
    }
}
