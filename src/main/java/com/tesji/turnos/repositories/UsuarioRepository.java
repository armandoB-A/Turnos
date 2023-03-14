package com.tesji.turnos.repositories;

import com.tesji.turnos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsuarioAndPassword(String usuario, String password);
}