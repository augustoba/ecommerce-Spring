/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.UsuarioModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nickler
 */
@Service
public interface UsuarioService {
    List<UsuarioModel> findAll(); 
    Optional<UsuarioModel> findById(Integer id);
    UsuarioModel save(UsuarioModel usuario);
    Optional<UsuarioModel> findByMail(String mail);

   
}
