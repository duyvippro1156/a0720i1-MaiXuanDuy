package com.codegym.blog_authen.services;

import com.codegym.blog_authen.models.Users;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    Users findUserByEmail(String email);
}
