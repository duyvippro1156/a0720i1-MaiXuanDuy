package com.codegym.endmodule.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;

    @OneToMany(mappedBy = "user_create")
    private List<Question> questionListCreate;

    @OneToMany(mappedBy = "user_feedback")
    private List<Question> questionListFeedback;


    public User(String name, String password) {
    }


}
