package com.proyecto.cibertec.proyecto.interfaces;

import com.proyecto.cibertec.proyecto.entity.EUsuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<EUsuario> obtenerUsuarios();

    public EUsuario obtenerUsuarioPorId(Long id);

    public EUsuario guardarUsuario(EUsuario usuario);

    EUsuario buscarPorNombreUsuario(String nombreUsuario);

    public void eliminarUsuario(Long id);

    public Optional<EUsuario> getByNombreUsuario(String nombreUsuario);

    public boolean existsByNombreUsuario(String nombreUsuario);

    public boolean existsByEmail(String email);
}
