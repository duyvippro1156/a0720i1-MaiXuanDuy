package com.codegym.endmodule.model.dto;

import java.time.LocalDate;


public interface ListQuestionDTO {
    int getId();
    String getTitle();
    String getTypeName();
    LocalDate getDate_create();
    String getUser_create();
    String getUser_feedback();
    String getStatus();
    Boolean getDelete_flag();
}
