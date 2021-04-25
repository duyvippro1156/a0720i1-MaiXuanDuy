package com.codegym.blog_authen.repositories;

import com.codegym.blog_authen.models.Users;
import com.codegym.blog_authen.models.UserRole;
import com.codegym.blog_authen.models.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {
    Set<UserRole> findByUser(Users users);
}
