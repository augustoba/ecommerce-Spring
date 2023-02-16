
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.OrdenModel;
import com.ecommerce.springboot.model.UsuarioModel;
import java.util.List;
import java.util.Optional;



public interface OrdenService {
    List<OrdenModel> findAll();
    Optional<OrdenModel> findById(Integer id);
    OrdenModel save(OrdenModel ordenModel);
    String generarNumeroOrden();
    List<OrdenModel> findByUsuario(UsuarioModel usuario);
}