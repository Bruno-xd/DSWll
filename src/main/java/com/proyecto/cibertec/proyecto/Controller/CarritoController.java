package com.proyecto.cibertec.proyecto.Controller;

import com.proyecto.cibertec.proyecto.Entity.ECarrito;
import com.proyecto.cibertec.proyecto.Entity.EProducto;
import com.proyecto.cibertec.proyecto.Interfaces.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    private ICarritoService carritoService;

    @PostMapping("/{idUsuario}/productos/{idProducto}")
    public ResponseEntity<?> agregarProducto(@PathVariable Long idUsuario, @PathVariable Long idProducto) {
        try {
            carritoService.agregarProducto(idUsuario, idProducto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar producto al carrito");
        }
    }

    @DeleteMapping("/{idUsuario}/eliminar/{idProducto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long idUsuario, @PathVariable Long idProducto) {
        try {
            carritoService.eliminarProducto(idUsuario, idProducto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar producto del carrito");
        }
    }

    @GetMapping("/usuario/productos/{idUsuario}")
    public ResponseEntity<List<EProducto>> getProductosDelCarritoByUsuario(@PathVariable Long idUsuario) {
        ECarrito carrito = carritoService.getCarritoByUsuario(idUsuario);
        List<EProducto> productos = carritoService.getProductos(carrito.getId_carrito());
        return ResponseEntity.ok(productos);
    }
}
