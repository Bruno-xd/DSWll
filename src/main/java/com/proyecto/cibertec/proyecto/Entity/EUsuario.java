package com.proyecto.cibertec.proyecto.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;

import com.proyecto.cibertec.proyecto.security.Entity.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class EUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<EProducto> productos;
    @Column(unique = true)
    private String nombreUsuario;
    private String nombreApellido;
    private String password;
    private String email;
    private String telefono;
    private String ubicacion;

    // Nueva relación uno a uno con la entidad ECarrito
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private ECarrito carrito;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    // Constructor
    public EUsuario() {}
    public EUsuario(String nombre,String nombre_User,String pass,String email,String telefono,String ubi){
        this.nombreApellido = nombre;
        this.nombreUsuario = nombre_User;
        this.password = pass;
        this.email = email;
        this.telefono = telefono;
        this.ubicacion = ubi;
    }
}
