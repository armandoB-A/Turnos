package com.tesji.turnos.repositories;

import com.tesji.turnos.entities.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepository extends JpaRepository<Caja, Integer> {
    Caja findFirstByOcupada(Boolean ocupada);
}