package com.codegym.endmodule.service.impl;

import com.codegym.endmodule.model.dto.ListQuestionDTO;
import com.codegym.endmodule.repository.QuestionRepository;
import com.codegym.endmodule.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Page<ListQuestionDTO> getListQuestion(Pageable pageable) {
        return this.questionRepository.getListQuestion(pageable);
    }
}
