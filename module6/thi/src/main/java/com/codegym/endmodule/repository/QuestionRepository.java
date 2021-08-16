package com.codegym.endmodule.repository;

import com.codegym.endmodule.model.dto.ListQuestionDTO;
import com.codegym.endmodule.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "select question.id, question.title, question_type.name as typeName, question.date_create, question.user_create, question.user_feedback, question.status \n" +
            "from question \n" +
            "left join question_type on question_type.id = question.question_type_id", nativeQuery = true)
    Page<ListQuestionDTO> getListQuestion(Pageable pageable);

//    @Query(value = )
}
