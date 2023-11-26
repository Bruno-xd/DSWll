package com.proyecto.cibertec.proyecto.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cibertec.proyecto.Security.User.User;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "carrito")
public class ECarrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private User usuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carrito_productos",
           joinColumns = @JoinColumn(name = "id_carrito"),
           inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<EProducto> productos = new ArrayList<>();

    public void agregarProducto(EProducto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto(EProducto producto) {
        this.productos.remove(producto);
    }
    // Constructor vacío
    public ECarrito() {
    }
}