package com.codegym.blog_authen.services.impl;

import com.codegym.blog_authen.models.Role;
import com.codegym.blog_authen.repositories.RoleRepository;
import com.codegym.blog_authen.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

}
