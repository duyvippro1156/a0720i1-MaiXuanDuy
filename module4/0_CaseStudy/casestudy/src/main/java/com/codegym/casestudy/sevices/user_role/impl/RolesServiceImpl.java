package com.codegym.casestudy.sevices.user_role.impl;

import com.codegym.casestudy.models.user_role.Roles;
import com.codegym.casestudy.repositories.user_role.RolesRepository;
import com.codegym.casestudy.sevices.user_role.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles findById(int id) {
        return rolesRepository.findById(id).orElse(null);
    }
}
