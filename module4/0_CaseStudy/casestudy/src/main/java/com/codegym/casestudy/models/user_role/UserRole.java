package com.codegym.casestudy.models.user_role;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleKey id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private Users users;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Roles roles;

    public UserRole() {
    }

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
