package com.proyecto.cibertec.proyecto.Security.User;

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
    private Role Role;
    public Rol(){}

    public Rol(Role Role) {
        this.Role = Role;
    }
    
}
