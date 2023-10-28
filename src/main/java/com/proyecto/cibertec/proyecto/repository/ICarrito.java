package com.proyecto.cibertec.proyecto.repository;

import com.proyecto.cibertec.proyecto.entity.ECarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarrito extends JpaRepository<ECarrito, Long> {
}
