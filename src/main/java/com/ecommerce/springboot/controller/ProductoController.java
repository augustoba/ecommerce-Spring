
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.model.UsuarioModel;
import com.ecommerce.springboot.service.ProductoServiceImp;
import com.ecommerce.springboot.service.UploadFileService;
import com.ecommerce.springboot.service.UsuarioService;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpSession;
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


@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    
    @Autowired
    private ProductoServiceImp productoService;
    
    @Autowired
    private UploadFileService upload;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }
    
    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }
    
    @PostMapping("/save")
    public String save(ProductoModel producto, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
        LOGGER.info("Este es el objeto producto {}", producto);
        
        UsuarioModel u = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        producto.setUsuario(u);
         
        //imagen
        if (producto.getId() == null) { // cuando se crea un producto
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        } else {
            
        }
        productoService.save(producto);
        return "redirect:/productos";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        ProductoModel producto = new ProductoModel();
        Optional<ProductoModel> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        
        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);
        
        return "productos/edit";
    }
    
    @PostMapping("/update")
    public String update(ProductoModel producto, @RequestParam("img") MultipartFile file) throws IOException {
        
        ProductoModel p = new ProductoModel();
        p = productoService.get(producto.getId()).get();
        
        if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem

            producto.setImagen(p.getImagen());
        } else {// cuando se edita tbn la imagen			
            //eliminar cuando no sea la imagen por defecto
            if (!p.getImagen().equals("default.jpg")) {
                upload.deleteImage(p.getImagen());
            }
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        ProductoModel p = new ProductoModel();
        p = productoService.get(id).get();
        //eliminar cuando no sea la imagen por defecto
        if (!p.getImagen().equals("default.jpg")) {
            upload.deleteImage(p.getImagen());
        }
        productoService.delete(id);
        
        return "redirect:/productos";
    }
}
