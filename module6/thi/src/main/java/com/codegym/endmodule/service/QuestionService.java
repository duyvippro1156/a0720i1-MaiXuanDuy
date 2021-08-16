package com.codegym.endmodule.service;

import com.codegym.endmodule.model.dto.ListQuestionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    Page<ListQuestionDTO> getListQuestion(Pageable pageable);
}
