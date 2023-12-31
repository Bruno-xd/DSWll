package com.proyecto.cibertec.proyecto.Interfaces;

import com.proyecto.cibertec.proyecto.Entity.EProducto;

import java.util.List;

public interface IProductoService {
    public List<EProducto> obtenerTodosProductos();

    public EProducto obtenerProductoPorId(Long id);

    public List<EProducto> obtenerProductosPorNombre(String nombre);

    public EProducto crearProducto(EProducto producto);

    public EProducto actualizarProducto(Long id, EProducto producto);

    public void eliminarProducto(Long id);
}
