package com.proyecto.cibertec.proyecto.Service;

import com.proyecto.cibertec.proyecto.Interfaces.IUsuarioService;
import com.proyecto.cibertec.proyecto.Repository.IUsuario;
import com.proyecto.cibertec.proyecto.Security.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpUsuario implements IUsuarioService {

    @Autowired
    IUsuario UsuarioRepo;
    @Override
    public List<User> obtenerUsuarios() {
        return UsuarioRepo.findAll();
    }

    @Override
    public User obtenerUsuarioPorId(Long id) {
        return UsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public User obtenerUsuarioPorEmail(String email) {
        return UsuarioRepo.findByUsername(email);
    }

    @Override
    public User guardarUsuario(User usuario) {
        return UsuarioRepo.save(usuario);
    }

    /*@Override
    public User buscarPorNombreUsuario(String nombreUsuario) {
        return UsuarioRepo.findByNombreUsuario(nombreUsuario).orElse(null);
    }
*/
    @Override
    public void eliminarUsuario(Long id) {
        UsuarioRepo.deleteById(id);
    }

    /*@Override
    public Optional<User> getByNombreUsuario(String nombreUsuario) {
        return UsuarioRepo.findByNombreUsuario(nombreUsuario);
    }*/
/*
    @Override
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return UsuarioRepo.existsByNombreUsuario(nombreUsuario);
    }*/

    /*@Override
    public boolean existsByEmail(String email) {
        return UsuarioRepo.existsByEmail(email);
    }
     */
}
