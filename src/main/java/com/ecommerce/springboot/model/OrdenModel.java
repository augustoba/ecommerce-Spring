
package com.ecommerce.springboot.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "ordenes")
@Data
public class OrdenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;
    
    @ManyToOne
    private UsuarioModel usuario;
    
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrdenModel> detalle;

}
