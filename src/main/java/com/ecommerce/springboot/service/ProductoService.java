/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.ProductoModel;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nickler
 */
@Service
public interface ProductoService {
    public ProductoModel save(ProductoModel producto);
    public Optional<ProductoModel> get(Integer id);
    public void update(ProductoModel producto);
    public void delete(Integer id);
        
}
