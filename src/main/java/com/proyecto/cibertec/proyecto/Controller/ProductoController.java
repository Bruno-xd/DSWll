package com.proyecto.cibertec.proyecto.Controller;

import com.proyecto.cibertec.proyecto.Entity.EProducto;
import com.proyecto.cibertec.proyecto.Entity.EUsuario;
import com.proyecto.cibertec.proyecto.Interfaces.IProductoService;
import com.proyecto.cibertec.proyecto.Interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
    @Autowired
    IProductoService iProducS;
    @Autowired
    IUsuarioService iUserS;

    @GetMapping("/productos")
    public List<EProducto> verProductos() {
        return iProducS.obtenerTodosProductos();
    }
    @GetMapping("/producto/buscar/{id}")
    public EProducto buscarProduc(@PathVariable Long id) {
        return iProducS.obtenerProductoPorId(id);
    }
    @GetMapping("/producto/buscarNombre/{nombre}")
    public List<EProducto> obtenerProductosPorNombre(@PathVariable String nombre) {
        return iProducS.obtenerProductosPorNombre(nombre);
    }

    @PostMapping("/producto/crear")
    public ResponseEntity<Map<String, String>> crearProduc(@RequestBody EProducto produc) {
//        EUsuario proveedor = iUserS.obtenerUsuarioPorId(idProveedor);
//        produc.setProveedor(proveedor);
        iProducS.crearProducto(produc);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Producto creado exitosamente.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/producto/editar/{id}")
    public EProducto actualizarProducto(@PathVariable Long id, @RequestBody EProducto productoActualizado) {
        EProducto producto = iProducS.obtenerProductoPorId(id);

        producto.setNombre(productoActualizado.getNombre());
        producto.setEtiquetas(productoActualizado.getEtiquetas());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setImagen(productoActualizado.getImagen());
        producto.setCantidad(productoActualizado.getCantidad());

        return iProducS.crearProducto(producto);
    }

    @DeleteMapping("/producto/borrar/{id}")
    public ResponseEntity<String> borrarProduc(@PathVariable Long id) {
        iProducS.eliminarProducto(id);
        return ResponseEntity.ok().body("{\"mensaje\": \"Producto eliminado correctamente\"}");
    }
}
