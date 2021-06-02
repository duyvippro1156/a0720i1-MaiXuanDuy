package com.codegym.casestudy.sevices.user_role;

import com.codegym.casestudy.models.user_role.UserRole;
import com.codegym.casestudy.models.user_role.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserRoleService {
    List<UserRole> findAll();
    void save(UserRole userRole);
    Set<UserRole> findByUsers(Users users);
    void deleteAllByUsername(String username);
}
