package com.codegym.casestudy.repositories.user_role;

import com.codegym.casestudy.models.user_role.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
