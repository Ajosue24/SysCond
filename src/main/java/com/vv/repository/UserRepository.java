package com.vv.repository;

import com.vv.model.UserAndRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAndRol,String> {

    List<UserAndRol> findByIdUsuarioAndHabilitado(String idUsuario,Boolean habilitado);
}
