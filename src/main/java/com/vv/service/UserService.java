package com.vv.service;

import com.vv.model.UserAndRol;

import java.util.List;

public interface UserService {

    List<UserAndRol> listaUsuariosYHablitados(String nombreUsuario,Boolean habilitado);

    void guardarEditarUsuario(UserAndRol userAndRol);

    List<UserAndRol> listaUsuario();

    UserAndRol buscarUsuario(String nombreUsuario);
}
