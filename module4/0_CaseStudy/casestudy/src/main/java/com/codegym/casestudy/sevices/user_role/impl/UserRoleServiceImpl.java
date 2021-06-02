package com.codegym.casestudy.sevices.user_role.impl;

import com.codegym.casestudy.models.user_role.UserRole;
import com.codegym.casestudy.models.user_role.Users;
import com.codegym.casestudy.repositories.user_role.UserRoleRepository;
import com.codegym.casestudy.sevices.user_role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public Set<UserRole> findByUsers(Users users) {
        return userRoleRepository.findByUsers(users);
    }

    @Override
    public void deleteAllByUsername(String username) {
        userRoleRepository.deleteUserRolesByUsers_Username(username);
    }
}
