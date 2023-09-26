package com.proyecto.cibertec.proyecto.security.Entity;

import com.proyecto.cibertec.proyecto.security.Enums.RolNombre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    public Rol(){}

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
