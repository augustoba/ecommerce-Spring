/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.springboot.repository;

import com.ecommerce.springboot.model.DetalleOrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nickler
 */
@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenModel, Integer>{
    
}
