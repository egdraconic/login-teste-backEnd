package com.example.demo.Configuracao.seguranca;

import com.example.demo.Entities.Usuario;
import com.example.demo.Repositories.usuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class autenticationControler {
    private final AuthenticationManager authenticationManager;
    private final usuarioRepository usuarioRepository;

    @Autowired
    autenticationControler(AuthenticationManager authenticationManager, usuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)  {
        var usernamePasssword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePasssword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/Registrar")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.usuarioRepository.findByemail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        assert encryptedPassword != null;
        Usuario novoUsuario = new Usuario(null ,data.nome() , encryptedPassword, data.email(), data.role());

        this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }
}
