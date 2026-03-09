package com.example.demo.Repositories;

import com.example.demo.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Long> {
     Usuario findByNomeAndEmail(String nome, String email);
     Usuario findByNome(String nome);
     Usuario findByemail(String email);
}
