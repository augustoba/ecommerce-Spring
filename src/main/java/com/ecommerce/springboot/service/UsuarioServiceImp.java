
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.UsuarioModel;
import com.ecommerce.springboot.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<UsuarioModel> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioModel save(UsuarioModel usuario) {
       return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<UsuarioModel> findByMail(String mail) {
        return usuarioRepository.findByMail(mail);
    }

    @Override
    public List<UsuarioModel> findAll() {
       return usuarioRepository.findAll();
    }

}
