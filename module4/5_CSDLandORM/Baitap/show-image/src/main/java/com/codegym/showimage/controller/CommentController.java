package com.codegym.showimage.controller;

import com.codegym.showimage.model.Comment;
import com.codegym.showimage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("comments", commentService.findAll());
        model.addAttribute("comment", new Comment());
        model.addAttribute("ratingList", new int[]{1, 2, 3, 4, 5});
        return "index";
    }
}
