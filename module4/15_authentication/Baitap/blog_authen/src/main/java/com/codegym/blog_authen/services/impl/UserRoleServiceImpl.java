package com.codegym.blog_authen.services.impl;

import com.codegym.blog_authen.models.Users;
import com.codegym.blog_authen.models.UserRole;
import com.codegym.blog_authen.repositories.UserRoleRepository;
import com.codegym.blog_authen.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Set<UserRole> findByUser(Users users) {
        return userRoleRepository.findByUser(users);
    }
}
