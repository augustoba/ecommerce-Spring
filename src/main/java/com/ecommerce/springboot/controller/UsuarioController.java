/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.UsuarioModel;
import com.ecommerce.springboot.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nickler
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String create() {
        return "usuario/registro";
    }

    @PostMapping("/save")
    public String save(UsuarioModel usuario) {
       
        logger.info("Usuario registro: {}", usuario);
        usuario.setTipo("USER");
        usuarioService.save(usuario);
        
        return "redirect:/";
    }

}
