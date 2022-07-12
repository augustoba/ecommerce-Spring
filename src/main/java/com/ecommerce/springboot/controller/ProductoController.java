/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.service.ProductoService;
import com.ecommerce.springboot.service.UploadFileService;
import java.io.IOException;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    
    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model modelo) {
        modelo.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(ProductoModel producto,@RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("Este es el objeto producto{}", producto); //Para realizar pruebas por consola.
        productoService.save(producto);
        
        //imagen
        if(producto.getId()==null){ //cuando se crea un producto
            String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }else{
            if(file.isEmpty()){ //editamos la imagen
                ProductoModel p = new ProductoModel();
                p=productoService.get(producto.getId()).get();
                producto.setImagen(p.getImagen());
            }
            else{
                 String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);
            }
        }
        
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model modelo) {
        ProductoModel producto = new ProductoModel();
        Optional<ProductoModel> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        modelo.addAttribute("producto", producto);

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(ProductoModel producto) {
        productoService.update(producto);
        return "redirect:/productos";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);
        return "redirect:/productos";
    }
}
