package com.cs.idsProject.repository;



import com.cs.idsProject.entity.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntoRepository extends JpaRepository<POI, Integer> {
}
