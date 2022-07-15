/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.OrdenModel;
import java.util.List;


/**
 *
 * @author Nickler
 */
public interface OrdenService {
    List<OrdenModel> findAll();
    OrdenModel save(OrdenModel ordenModel);
    String generarNumeroOrden();
}