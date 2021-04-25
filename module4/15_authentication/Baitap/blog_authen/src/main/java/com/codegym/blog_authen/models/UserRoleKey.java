package com.codegym.blog_authen.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRoleKey implements Serializable {
    @Column(name = "user_id")
    int userId;

    @Column(name = "role_id")
    int roleId;

    public UserRoleKey() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int id) {
        this.roleId = id;
    }
}
