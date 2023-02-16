
package com.ecommerce.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "detalles")
@Data
public class DetalleOrdenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    @ManyToOne
    private OrdenModel orden;
    
    @ManyToOne
    private ProductoModel producto;
}
