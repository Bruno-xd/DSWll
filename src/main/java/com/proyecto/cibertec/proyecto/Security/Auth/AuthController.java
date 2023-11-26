package com.proyecto.cibertec.proyecto.Security.Auth;

import com.proyecto.cibertec.proyecto.Interfaces.ICarritoService;
import com.proyecto.cibertec.proyecto.Security.User.User;
import com.proyecto.cibertec.proyecto.Service.ImpCarrito;
import com.proyecto.cibertec.proyecto.Service.ImpUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    ImpCarrito carritoService;
    @Autowired
    ImpUsuario usuarioService;

    private final AuthService authService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        ResponseEntity responseEntity = ResponseEntity.ok(authService.register(request));
        User createdUser = usuarioService.obtenerUsuarioPorEmail(request.getUsername());
        carritoService.crearCarrito(createdUser);
        return responseEntity;
    }
}
