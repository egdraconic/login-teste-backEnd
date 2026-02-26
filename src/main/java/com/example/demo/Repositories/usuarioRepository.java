package com.example.demo.Repositories;

import com.example.demo.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNomeAndEmail(String Nome, String Email);
}
