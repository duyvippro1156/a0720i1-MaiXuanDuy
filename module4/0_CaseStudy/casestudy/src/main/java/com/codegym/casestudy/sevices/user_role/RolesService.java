package com.codegym.casestudy.sevices.user_role;

import com.codegym.casestudy.models.user_role.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolesService {
    List<Roles> findAll();
    Roles findById(int id);
}
