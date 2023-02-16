
package com.ecommerce.springboot.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
public class UsuarioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String nombre;
    private String username;
    private String mail;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;


    @OneToMany(mappedBy = "usuario")
    private List<ProductoModel> productos;
    
    @OneToMany(mappedBy = "usuario")
    private List<OrdenModel> ordenes;

}
