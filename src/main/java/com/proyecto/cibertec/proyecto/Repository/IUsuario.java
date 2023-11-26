package com.proyecto.cibertec.proyecto.Repository;

import com.proyecto.cibertec.proyecto.Security.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuario extends JpaRepository<User, Long> {
    User findByUsername(String email);

    //boolean existsByEmail(String email);
    //Optional<User> findByNombreUsuario(String nombreUsuario);

    //boolean existsByNombreUsuario(String nombreUsuario);
}
