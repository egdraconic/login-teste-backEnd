package com.example.demo.Entities;

import com.example.demo.Enum.UsuarioRole;
import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String nome;

    @NonNull
    @Column(unique = true)
    private String senha;

    @NonNull
    @Column(unique = true)
    private String email;

    @NonNull
    private UsuarioRole role;

    public Usuario(Long id, @NonNull String nome, @NonNull String senha, @NonNull String email, @NonNull UsuarioRole role) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.role = role;
    }

    public Usuario(@NonNull String nome, @NonNull String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NonNull String getnome() {
        return nome;
    }

    public void setnome(@NonNull String nome) {
        this.nome = nome;
    }

    public @NonNull String getSenha() {
        return senha;
    }

    public void setSenha(@NonNull String senha) {
        this.senha = senha;
    }

    public @NonNull String getemail() {
        return email;
    }

    public void setemail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull UsuarioRole getRole() {
        return role;
    }

    public void setRole(@NonNull UsuarioRole role) {
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsuarioRole.ADIMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USUARIO"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    @NonNull
    public String getUsername() {
        return getemail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
