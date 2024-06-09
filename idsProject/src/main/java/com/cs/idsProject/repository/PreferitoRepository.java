package com.cs.idsProject.repository;

import com.cs.idsProject.entity.Preferito;
import com.cs.idsProject.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferitoRepository extends JpaRepository<Preferito, Integer> {
    List<Preferito> findByUtente(Utente utente);
}
