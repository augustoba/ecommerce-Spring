
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.ProductoModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public interface ProductoService {
    public ProductoModel save(ProductoModel producto);
    public Optional<ProductoModel> get(Integer id);
    public void update(ProductoModel producto);
    public void delete(Integer id);
    public List<ProductoModel> findAll();
}
