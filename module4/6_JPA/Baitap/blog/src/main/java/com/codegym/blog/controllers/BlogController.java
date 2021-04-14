package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView getList() {
        return new ModelAndView("index", "blog", blogService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("blog", new Blog());
        return model;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
        if (blog.getId() == 0) {
            blog.setCreatedTime(LocalDate.now());
        }
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }


}
