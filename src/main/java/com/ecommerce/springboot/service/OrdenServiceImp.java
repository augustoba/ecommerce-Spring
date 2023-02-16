
package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.OrdenModel;
import com.ecommerce.springboot.model.UsuarioModel;
import com.ecommerce.springboot.repository.OrdenRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdenServiceImp implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public OrdenModel save(OrdenModel orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public List<OrdenModel> findAll() {
        return ordenRepository.findAll();
    }

    public String generarNumeroOrden() {
        int numero = 0;
        String numeroConcatenado = "";

        List<OrdenModel> ordenes = findAll();

        List<Integer> numeros = new ArrayList<>();

        ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

        if (ordenes.isEmpty()) {
            numero = 1;
        } else {
            numero = numeros.stream().max(Integer::compare).get();
            numero++;
        }
        
        if (numero < 10) {
            numeroConcatenado = "000000000" + String.valueOf(numero);
        } else if (numero < 100) {
            numeroConcatenado = "00000000" + String.valueOf(numero);
        } else if (numero < 1000) {
            numeroConcatenado = "0000000" + String.valueOf(numero);
        } else if (numero < 10000) {
            numeroConcatenado = "0000000" + String.valueOf(numero);
        } else if (numero < 100000) {
            numeroConcatenado = "0000000" + String.valueOf(numero);
        }
        return numeroConcatenado;
    }

    @Override
    public List<OrdenModel> findByUsuario(UsuarioModel usuario) {
       return ordenRepository.findByUsuario(usuario);
    }

    @Override
    public Optional<OrdenModel> findById(Integer id) {
       return ordenRepository.findById(id);
    }

}
