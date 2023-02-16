
package com.ecommerce.springboot.repository;

import com.ecommerce.springboot.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer>{
    
}
