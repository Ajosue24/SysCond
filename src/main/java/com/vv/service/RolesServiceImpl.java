package com.vv.service;

import com.vv.model.Roles;
import com.vv.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolesServiceImpl implements RolesService{

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void guardarRolesPorUsuario(Roles roles) {
        rolesRepository.save(roles);
    }
}
