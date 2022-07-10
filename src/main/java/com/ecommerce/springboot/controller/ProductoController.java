/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.model.UsuarioModel;
import com.ecommerce.springboot.service.ProductoService;
import static org.apache.tomcat.jni.User.username;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nickler
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("")
    public String show(Model modelo){
        modelo.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }
    
    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }
    
    @PostMapping("/save")
    public String save(ProductoModel producto){
        LOGGER.info("Este es el objeto producto{}", producto); //Para realizar pruebas por consola.
        productoService.save(producto);
        return "redirect:/productos";
    }
}
