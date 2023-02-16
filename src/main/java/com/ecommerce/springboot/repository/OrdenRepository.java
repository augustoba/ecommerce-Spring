
package com.ecommerce.springboot.repository;

import com.ecommerce.springboot.model.OrdenModel;
import com.ecommerce.springboot.model.UsuarioModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdenRepository extends JpaRepository<OrdenModel, Integer>{
    List<OrdenModel> findByUsuario(UsuarioModel usuario);
}
