package org.orderFlow.service;

import org.orderFlow.model.Usuario;
import org.orderFlow.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByUser(String user) {
        return usuarioRepository.findByUser(user);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void saveAll(List<Usuario> usuarios) {
        usuarioRepository.saveAll(usuarios);
    }
}
