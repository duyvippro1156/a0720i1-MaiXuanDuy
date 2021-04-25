package com.codegym.blog_authen.repositories;

import com.codegym.blog_authen.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findUserByEmail(String email);
}
