package com.tesji.turnos.repositories;

import com.tesji.turnos.entities.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
}