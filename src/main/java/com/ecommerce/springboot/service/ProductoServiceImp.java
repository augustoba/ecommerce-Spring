
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.ProductoModel;
import com.ecommerce.springboot.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoModel save(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<ProductoModel> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void update(ProductoModel producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
       productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoModel> findAll() {
       return productoRepository.findAll();
    }

}
