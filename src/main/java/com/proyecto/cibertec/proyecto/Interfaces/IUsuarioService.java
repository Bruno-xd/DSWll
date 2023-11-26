package com.proyecto.cibertec.proyecto.Interfaces;

import com.proyecto.cibertec.proyecto.Security.User.User;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<User> obtenerUsuarios();

    public User obtenerUsuarioPorId(Long id);
    public User obtenerUsuarioPorEmail(String email);

    public User guardarUsuario(User usuario);

    //User buscarPorNombreUsuario(String nombreUsuario);

    public void eliminarUsuario(Long id);

    //public Optional<User> getByNombreUsuario(String nombreUsuario);

    //public boolean existsByNombreUsuario(String nombreUsuario);

    //public boolean existsByEmail(String email);
}
