package com.codegym.endmodule.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    @Query(value = "select user.id from user where user.username = ?1 limit 1", nativeQuery = true)
    int getIdAccountByUsername(String username);
}
