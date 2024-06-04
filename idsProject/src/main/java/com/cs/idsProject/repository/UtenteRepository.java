package com.cs.idsProject.repository;

import com.cs.idsProject.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    Utente findByUsername(String username);
}
