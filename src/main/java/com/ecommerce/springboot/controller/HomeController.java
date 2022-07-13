/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.DetalleOrdenModel;
import com.ecommerce.springboot.model.OrdenModel;
import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.model.UsuarioModel;
import com.ecommerce.springboot.service.ProductoService;
import com.ecommerce.springboot.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nickler
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService; //interface

    //Para almacenar los detalles de la orden.
    List<DetalleOrdenModel> detalles = new ArrayList<DetalleOrdenModel>();

    //Objeto que almacena datos de la orden.
    OrdenModel orden = new OrdenModel();

    @GetMapping
    public String home(Model modelo) {

        modelo.addAttribute("productos", productoService.findAll());

        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model modelo) {
        log.info("Id producto enviado como parametro {}", id);
        ProductoModel producto = new ProductoModel();
        Optional<ProductoModel> productoOptional = productoService.get(id);
        producto = productoOptional.get();

        modelo.addAttribute("producto", producto);

        return "usuario/productohome";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model modelo) {
        DetalleOrdenModel detalleOrden = new DetalleOrdenModel();
        ProductoModel producto = new ProductoModel();
        double sumaTotal = 0;

        Optional<ProductoModel> optionalProducto = productoService.get(id);
        log.info("Producto añadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);
        producto = optionalProducto.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio() * cantidad);
        detalleOrden.setProducto(producto);

        //validar que el producto no se añada 2 veces
        Integer idProducto = producto.getId();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);

        if (!ingresado) {
            detalles.add(detalleOrden);
        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        modelo.addAttribute("cart", detalles);
        modelo.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    //quitar producto del carrito
    @GetMapping("/delete/cart/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model modelo) {

        List<DetalleOrdenModel> ordenesNueva = new ArrayList<>();

        for (DetalleOrdenModel detalleOrden : detalles) {
            if (detalleOrden.getProducto().getId() != id) {
                ordenesNueva.add(detalleOrden);
            }
        }

        //poner la nueva lista con los productos restantes
        detalles = ordenesNueva;

        double sumaTotal = 0;
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        modelo.addAttribute("cart", detalles);
        modelo.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/getCart")
    public String getCart(Model modelo) {

        modelo.addAttribute("cart", detalles);
        modelo.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/order")
    public String order(Model modelo) {
        
        UsuarioModel usuario = usuarioService.findById(1).get();
        
        modelo.addAttribute("cart", detalles);
        modelo.addAttribute("orden", orden);
        modelo.addAttribute("usuario", usuario);

        return "usuario/resumenorden";
    }
}
