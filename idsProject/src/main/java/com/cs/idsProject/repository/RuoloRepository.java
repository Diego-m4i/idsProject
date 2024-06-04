package com.cs.idsProject.repository;

import com.cs.idsProject.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {
}
