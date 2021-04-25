package com.codegym.blog_authen.models;

import javax.persistence.*;

@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public Users getUsers() {
        return user;
    }

    public void setUsers(Users users) {
        this.user = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}