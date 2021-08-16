package com.codegym.endmodule.controller;

import com.codegym.endmodule.model.dto.ListQuestionDTO;
import com.codegym.endmodule.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping("/question/list")
    public ResponseEntity<Page<ListQuestionDTO>> getListFilm(@PageableDefault(size = 5) Pageable pageable) {
        Page<ListQuestionDTO> listFilmDTOS = this.questionService.getListQuestion(pageable);
        if (listFilmDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listFilmDTOS, HttpStatus.OK);
    }


}
