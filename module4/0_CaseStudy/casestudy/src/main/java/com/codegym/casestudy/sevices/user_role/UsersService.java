package com.codegym.casestudy.sevices.user_role;

import com.codegym.casestudy.models.user_role.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<Users> findAll();
    Users findByUsername(String username);
    void save(Users users);
    void delete(String username);
    boolean existById(String username);
}
