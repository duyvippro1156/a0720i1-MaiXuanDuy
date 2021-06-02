package com.codegym.casestudy.models.user_role;

import com.codegym.casestudy.models.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {
    @Id
    private String username;
    private String password;

    @OneToOne(mappedBy = "users")
    private Employee employee;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    Set<UserRole> userRoles;

    public Users() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}