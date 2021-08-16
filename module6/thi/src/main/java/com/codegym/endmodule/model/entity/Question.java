package com.codegym.endmodule.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String question;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "question_type_id", referencedColumnName = "id")
    private QuestionType id_question_type;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date_create;

    @ManyToOne
    @JoinColumn(name = "user_create", referencedColumnName = "username")
    private User user_create;

    @ManyToOne
    @JoinColumn(name = "user_feedback", referencedColumnName = "username")
    private User user_feedback;
    private String status;
    private boolean delete_flag;

}
