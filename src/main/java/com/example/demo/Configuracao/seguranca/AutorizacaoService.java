package com.example.demo.Configuracao.seguranca;

import com.example.demo.Repositories.usuarioRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class AutorizacaoService implements UserDetailsService {

    private usuarioRepository repository;

    @Autowired
    AutorizacaoService(usuarioRepository repository) {
        this.repository = repository;
    }

    AutorizacaoService() {}

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) {
        return repository.findByemail(email);
    }
}
