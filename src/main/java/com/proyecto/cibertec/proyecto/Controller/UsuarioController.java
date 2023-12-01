package com.proyecto.cibertec.proyecto.Controller;

import com.proyecto.cibertec.proyecto.Interfaces.IUsuarioService;
import com.proyecto.cibertec.proyecto.Security.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    IUsuarioService iUserS;

    @GetMapping("/usuarios")
    public List<User> verUsuarios() {
        return iUserS.obtenerUsuarios();
    }
    @GetMapping("/usuario/buscar/{id}")
    public User buscarUser(@PathVariable Long id) {
        return iUserS.obtenerUsuarioPorId(id);
    }
    @GetMapping("/usuario/buscarE/{email}")
    public User buscarUserEmail(@PathVariable String email) {return iUserS.obtenerUsuarioPorEmail(email);}
    @DeleteMapping("/usuario/borrar/{id}")
    public ResponseEntity<String> borrarUser(@PathVariable Long id) {
        iUserS.eliminarUsuario(id);
        return ResponseEntity.ok().body("{\"mensaje\": \"Usuario, Se elimino correctamente\"}");
    }
}
