package com.tesji.turnos.repositories;

import com.tesji.turnos.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    Turno findFirstByAtendidoOrderByIdAsc(Boolean atendido);
    Turno findFirstByAtendido(Boolean atendido);
    List<Turno> findByAtendido(Boolean atendido);

    Turno findFirstByOrderByIdDesc();

}