package com.codegym.blog_authen.services;

import com.codegym.blog_authen.models.Users;
import com.codegym.blog_authen.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserRoleService {
    Set<UserRole> findByUser(Users users);
}
