package com.codegym.validate.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 45)
    private String firstName;
    @Size(min = 2, max = 45)
    private String lastName;
    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "SDT khong hop le!!")
    private String phoneNumber;
    @Min(18)
    private int age;
    @Pattern(regexp = "(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)", message = "Email theo mẫu example@gmail.com")
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
