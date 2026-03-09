package com.example.demo.Services;

import com.example.demo.Entities.Usuario;
import com.example.demo.Repositories.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {
    private final usuarioRepository repository;

    public usuarioService(usuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario insert (Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> findAll () {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    public Usuario findByNomeAndEmail(String Nome, String Email) {
        return repository.findByNomeAndEmail(Nome, Email);
    }
    public Usuario findByNome(String Nome) {
        return repository.findByNome(Nome);
    }

    public Usuario findByEmail(String email) {
        return repository.findByemail(email);
    }

    public void DeleteById(Long id) {
        repository.deleteById(id);
    }


}
