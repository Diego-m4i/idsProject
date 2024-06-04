package com.cs.idsProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cs.idsProject.entity.Comune;

public interface ComuneRepository extends JpaRepository<Comune, Integer> {
}
