package com.proyecto.cibertec.proyecto.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "productos")
public class EProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    
    @JsonIgnoreProperties({"productos", "password"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private EUsuario proveedor;
  
    private String nombre;
    private String etiquetas;
    private String descripcion;
    private Long precio;
    private String imagen;
    private Long cantidad; 
}
