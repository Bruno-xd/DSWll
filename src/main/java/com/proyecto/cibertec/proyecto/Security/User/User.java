package com.proyecto.cibertec.proyecto.Security.User;

import com.proyecto.cibertec.proyecto.Entity.ECarrito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    Integer id;
    @Basic
    @Column(name = "username")
    String username;
    @Column(name = "lastname")
    String lastname;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "country")
    String country;
    @Column(name = "password")
    String password;
    @Enumerated(EnumType.STRING) 
    Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrito",referencedColumnName = "id_carrito")
    private ECarrito carrito;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
