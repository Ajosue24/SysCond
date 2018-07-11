package com.vv.repository;

import com.vv.model.UserAndRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAndRol,Integer> {

    List<UserAndRol> findByNombreUsuarioAndHabilitado(String nombreUsuario,Boolean habilitado);
}
