package com.codegym.validate.Service.Impl;

import com.codegym.validate.Model.User;
import com.codegym.validate.Repository.UserRepository;
import com.codegym.validate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
