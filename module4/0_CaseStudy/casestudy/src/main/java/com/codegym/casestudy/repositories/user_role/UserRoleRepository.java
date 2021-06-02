package com.codegym.casestudy.repositories.user_role;

import com.codegym.casestudy.models.user_role.UserRole;
import com.codegym.casestudy.models.user_role.UserRoleKey;
import com.codegym.casestudy.models.user_role.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {
    Set<UserRole> findByUsers(Users users);
    void deleteUserRolesByUsers_Username(String username);
}
