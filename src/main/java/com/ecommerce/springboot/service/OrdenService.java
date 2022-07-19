/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.OrdenModel;
import com.ecommerce.springboot.model.UsuarioModel;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author Nickler
 */
public interface OrdenService {
    List<OrdenModel> findAll();
    Optional<OrdenModel> findById(Integer id);
    OrdenModel save(OrdenModel ordenModel);
    String generarNumeroOrden();
    List<OrdenModel> findByUsuario(UsuarioModel usuario);
}