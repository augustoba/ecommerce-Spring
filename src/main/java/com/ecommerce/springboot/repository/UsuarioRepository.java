
package com.ecommerce.springboot.repository;

import com.ecommerce.springboot.model.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByMail(String mail);
}
