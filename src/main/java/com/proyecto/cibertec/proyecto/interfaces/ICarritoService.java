package com.proyecto.cibertec.proyecto.interfaces;

import com.proyecto.cibertec.proyecto.entity.ECarrito;
import com.proyecto.cibertec.proyecto.entity.EProducto;
import com.proyecto.cibertec.proyecto.entity.EUsuario;

import java.util.List;

public interface ICarritoService {
    public void crearCarrito(EUsuario usuario);

    public void agregarProducto(Long idCarrito, Long idProducto);

    public void eliminarProducto(Long idCarrito,Long idProducto);

    public List<EProducto> getProductos(Long idCarrito);

    public ECarrito getCarritoByUsuario(Long idUsuario);
}
