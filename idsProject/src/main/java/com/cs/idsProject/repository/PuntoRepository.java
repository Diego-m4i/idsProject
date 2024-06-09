package com.cs.idsProject.repository;

import com.cs.idsProject.entity.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PuntoRepository extends JpaRepository<POI, Integer> {
    Optional<POI> findByNomeAndLatitudineAndLongitudineAndIdComune(String nome, float latitudine, float longitudine, Integer idComune);
    Optional<POI> findByIdAndIdComune(Integer id, Integer idComune);
}
