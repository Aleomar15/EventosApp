package com.CursoSpring.Aplicacao1.repository;

import com.CursoSpring.Aplicacao1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    Usuario findByLogin(String login);
}
