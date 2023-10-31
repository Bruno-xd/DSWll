package com.proyecto.cibertec.proyecto.Repository;

import com.proyecto.cibertec.proyecto.Entity.ECarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarrito extends JpaRepository<ECarrito, Long> {
}
