package com.proyecto.cibertec.proyecto.Interfaces;

import com.proyecto.cibertec.proyecto.Entity.ECarrito;
import com.proyecto.cibertec.proyecto.Entity.EProducto;
import com.proyecto.cibertec.proyecto.Entity.EUsuario;

import java.util.List;

public interface ICarritoService {
    public void crearCarrito(EUsuario usuario);

    public void agregarProducto(Long idCarrito, Long idProducto);

    public void eliminarProducto(Long idCarrito,Long idProducto);

    public List<EProducto> getProductos(Long idCarrito);

    public ECarrito getCarritoByUsuario(Long idUsuario);
}
