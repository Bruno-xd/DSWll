package com.proyecto.cibertec.proyecto.Controller;

import com.proyecto.cibertec.proyecto.Entity.EUsuario;
import com.proyecto.cibertec.proyecto.Interfaces.IUsuarioService;
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
    public List<EUsuario> verUsuarios() {
        return iUserS.obtenerUsuarios();
    }
    @GetMapping("/usuario/buscar/{id}")
    public EUsuario buscarUser(@PathVariable Long id) {
        return iUserS.obtenerUsuarioPorId(id);
    }
    @DeleteMapping("/usuario/borrar/{id}")
    public ResponseEntity<String> borrarUser(@PathVariable Long id) {
        iUserS.eliminarUsuario(id);
        return ResponseEntity.ok().body("{\"mensaje\": \"Usuario, Se elimino correctamente\"}");
    }
}
