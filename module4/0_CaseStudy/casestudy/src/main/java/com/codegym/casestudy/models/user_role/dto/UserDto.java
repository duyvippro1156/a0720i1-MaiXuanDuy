package com.codegym.casestudy.models.user_role.dto;

import com.codegym.casestudy.models.user_role.Roles;
import com.codegym.casestudy.models.user_role.Users;

import java.util.Set;

public class UserDto {
    private Users users;
    private Set<Roles> roles;

    public UserDto() {
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
