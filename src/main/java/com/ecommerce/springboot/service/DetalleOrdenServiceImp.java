/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.DetalleOrdenModel;
import com.ecommerce.springboot.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nickler
 */
@Service
public class DetalleOrdenServiceImp implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;
    
    @Override
    public DetalleOrdenModel save(DetalleOrdenModel detalleOrden) {
      return detalleOrdenRepository.save(detalleOrden);
    }
    
}
