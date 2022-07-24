/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.OrdenModel;
import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.service.OrdenService;
import com.ecommerce.springboot.service.ProductoService;
import com.ecommerce.springboot.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private OrdenService ordenService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String home(Model modelo) {

        List<ProductoModel> productos = productoService.findAll();
        modelo.addAttribute("productos", productos);

        return "/administrador/home";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model modelo) {
        modelo.addAttribute("usuarios", usuarioService.findAll());
        return "administrador/usuarios";
    }

    @GetMapping("/ordenes")
    public String ordenes(Model modelo) {
        modelo.addAttribute("ordenes", ordenService.findAll());
        return "administrador/ordenes";
    }
    
    @GetMapping("/detalle/{id}")
    public String detalle(Model modelo, @PathVariable Integer id){
        OrdenModel orden = ordenService.findById(id).get();
        
        modelo.addAttribute("detalles", orden.getDetalle());
        
        return "administrador/detalleorden";
    }
}
