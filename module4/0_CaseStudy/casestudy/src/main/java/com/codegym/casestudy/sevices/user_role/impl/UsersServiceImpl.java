package com.codegym.casestudy.sevices.user_role.impl;

import com.codegym.casestudy.models.user_role.Users;
import com.codegym.casestudy.repositories.user_role.UsersRepository;
import com.codegym.casestudy.sevices.user_role.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findById(username).orElse(null);
    }

    @Override
    public void save(Users appUser) {
        usersRepository.save(appUser);
    }

    @Override
    public void delete(String username) {
        usersRepository.deleteById(username);
    }

    @Override
    public boolean existById(String username) {
        return usersRepository.existsById(username);
    }
}
