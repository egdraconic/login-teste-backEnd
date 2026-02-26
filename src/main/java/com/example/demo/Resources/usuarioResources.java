package com.example.demo.Resources;

import com.example.demo.Entities.Usuario;
import com.example.demo.Services.usuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class usuarioResources {
    private final usuarioService usuarioService;

    public usuarioResources(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @GetMapping("/vef/usuarioNome/{nome}/email/{email}")
    public ResponseEntity<Usuario> findByUsuarioEmail(@PathVariable String nome, @PathVariable String email) {
        return ResponseEntity.ok().body(usuarioService.findByNomeAndEmail(nome, email));
    }

    @DeleteMapping
    public ResponseEntity<Void> DeleteById(@PathVariable Long id) {
        usuarioService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> Insert(@PathVariable Usuario usuario) {
        usuario = usuarioService.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

}
