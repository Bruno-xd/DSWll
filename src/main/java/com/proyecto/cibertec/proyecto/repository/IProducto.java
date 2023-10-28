package com.proyecto.cibertec.proyecto.repository;

import com.proyecto.cibertec.proyecto.entity.EProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProducto extends JpaRepository<EProducto, Long> {

    public List<EProducto> findByNombreContainingIgnoreCase(String nombre);

    public Optional<EProducto> findById(Long id);

    public void deleteById(Long id);
}
