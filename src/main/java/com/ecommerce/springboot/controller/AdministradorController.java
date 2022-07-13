/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nickler
 */
@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    
    @Autowired
    private ProductoService productoService;
    
    
    @GetMapping("")
    public String home(Model modelo){
        
        List<ProductoModel> productos=productoService.findAll();
        modelo.addAttribute("productos", productos);
        
        return "/administrador/home";
    }
}
