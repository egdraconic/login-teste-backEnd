package com.example.demo.Entities;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String Nome;

    @NonNull
    @Column(unique = true)
    private String senha;

    @NonNull
    @Column(unique = true)
    private String Email;

    public Usuario(Long id, @NonNull String Nome, @NonNull String senha, @NonNull String Email) {
        this.id = id;
        this.Nome = Nome;
        this.senha = senha;
        this.Email = Email;
    }

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NonNull String getNome() {
        return Nome;
    }

    public void setNome(@NonNull String Nome) {
        this.Nome = Nome;
    }

    public @NonNull String getSenha() {
        return senha;
    }

    public void setSenha(@NonNull String senha) {
        this.senha = senha;
    }

    public @NonNull String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String Email) {
        this.Email = Email;
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
