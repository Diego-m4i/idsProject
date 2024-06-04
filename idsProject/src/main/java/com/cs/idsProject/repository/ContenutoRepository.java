package com.cs.idsProject.repository;

import com.cs.idsProject.entity.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, Integer> {
}
