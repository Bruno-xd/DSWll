package com.proyecto.cibertec.proyecto.Service;

import com.proyecto.cibertec.proyecto.Entity.ECarrito;
import com.proyecto.cibertec.proyecto.Entity.EProducto;
import com.proyecto.cibertec.proyecto.Interfaces.ICarritoService;
import com.proyecto.cibertec.proyecto.Repository.ICarrito;
import com.proyecto.cibertec.proyecto.Repository.IProducto;
import com.proyecto.cibertec.proyecto.Repository.IUsuario;
import com.proyecto.cibertec.proyecto.Security.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpCarrito implements ICarritoService {

    @Autowired
    private ICarrito carritoRepository;

    @Autowired
    private IProducto productoRepository;

    @Autowired
    private IUsuario usuarioRepository;

    @Override
    public void crearCarrito(User usuario) {
        ECarrito carrito = new ECarrito();
        carrito.setUsuario(usuario);
        carritoRepository.save(carrito);
    }

    @Override
    public void agregarProducto(Long idUsuario, Long idProducto) {
        try {
            User usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            /*ECarrito carrito = usuario.getCarrito(); // Obtener el carrito asociado al usuario
            if (carrito == null) {
                carrito = new ECarrito();
                carrito.setUsuario(usuario);
            }

            EProducto producto = productoRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            carrito.agregarProducto(producto);
            carritoRepository.save(carrito);*/
        } catch (Exception e) {
            System.err.println("Error al agregar producto al carrito: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void eliminarProducto(Long idUsuario, Long idProducto) {
        User usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        /*ECarrito carrito = usuario.getCarrito();
        if (carrito == null) {
            throw new RuntimeException("El carrito del usuario está vacío");
        }
        EProducto producto = productoRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        carrito.eliminarProducto(producto);
        carritoRepository.save(carrito);*/
    }

    @Override
    public List<EProducto> getProductos(Long idCarrito) {
        ECarrito carrito = carritoRepository.findById(idCarrito).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return carrito.getProductos();
    }

    @Override
    public ECarrito getCarritoByUsuario(Long idUsuario) {
        User usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        //return usuario.getCarrito();
        return new ECarrito();
    }
}
