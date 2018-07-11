package com.vv.service;

import com.vv.model.UserAndRol;
import com.vv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserAndRol> listaUsuariosYHablitados(String nombreUsuario, Boolean habilitado) {
        return (List<UserAndRol>)userRepository.findByNombreUsuarioAndHabilitado(nombreUsuario,habilitado);
    }

    public void guardarEditarUsuario(UserAndRol usuario){
        try{
            userRepository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<UserAndRol> listaUsuario() {
        return (List<UserAndRol>)userRepository.findAll();
    }
}
