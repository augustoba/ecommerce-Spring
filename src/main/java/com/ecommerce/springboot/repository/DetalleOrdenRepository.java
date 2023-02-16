
package com.ecommerce.springboot.repository;

import com.ecommerce.springboot.model.DetalleOrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenModel, Integer>{
    
}
