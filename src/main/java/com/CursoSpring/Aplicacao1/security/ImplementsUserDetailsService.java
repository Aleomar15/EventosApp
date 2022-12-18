package com.CursoSpring.Aplicacao1.security;

import com.CursoSpring.Aplicacao1.model.Usuario;
import com.CursoSpring.Aplicacao1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository

public class ImplementsUserDetailsService implements UserDetailsService {
    @Autowired
    UsuarioRepository ur;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = ur.findByLogin(login);
        if(usuario ==  null){
            throw new UsernameNotFoundException("Usuario não encontardo");
        }
        return usuario;
    }
}
