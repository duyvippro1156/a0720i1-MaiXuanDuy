package com.codegym.casestudy.models.user_role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Roles {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "roles")
    Set<UserRole> userRoles;

    public Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Roles){
            Roles other = (Roles) obj;
            return other.getId() == this.id;
        };
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
