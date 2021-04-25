package com.codegym.blog_authen.services.impl;

import com.codegym.blog_authen.models.Users;
import com.codegym.blog_authen.repositories.UserRepository;
import com.codegym.blog_authen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Users findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
