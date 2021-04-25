package com.codegym.blog_authen.services;

import com.codegym.blog_authen.models.Role;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {

    Role findById(int id);
}
