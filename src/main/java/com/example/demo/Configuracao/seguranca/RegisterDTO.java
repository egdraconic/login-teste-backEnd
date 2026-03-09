package com.example.demo.Configuracao.seguranca;

import com.example.demo.Enum.UsuarioRole;

public record RegisterDTO(String email, Long id, String senha, UsuarioRole role, String nome) {
}
