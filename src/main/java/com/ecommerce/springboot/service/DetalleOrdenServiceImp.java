
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.DetalleOrdenModel;
import com.ecommerce.springboot.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImp implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;
    
    @Override
    public DetalleOrdenModel save(DetalleOrdenModel detalleOrden) {
      return detalleOrdenRepository.save(detalleOrden);
    }
    
}
