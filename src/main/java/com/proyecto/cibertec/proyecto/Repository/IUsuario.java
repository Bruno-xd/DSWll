package com.proyecto.cibertec.proyecto.Repository;

import com.proyecto.cibertec.proyecto.Entity.EUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuario extends JpaRepository<EUsuario, Long> {

    boolean existsByEmail(String email);
    Optional<EUsuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
}
