package com.codegym.casestudy.repositories.user_role;

import com.codegym.casestudy.models.user_role.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
}

