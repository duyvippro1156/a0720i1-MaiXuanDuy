package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.models.Category;
import com.codegym.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list_category")
    public ModelAndView getList() {
        return new ModelAndView("category/list_category", "categories", categoryService.findAll());
    }

    @GetMapping("/category/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("category/create");
        model.addObject("categories", new Category());
        return model;
    }

    @PostMapping("/category/save")
    public String save(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category/list_category";
    }

    @GetMapping("/{id}/category/delete")
    public String delete(@PathVariable int id) {
        categoryService.remove(id);
        return "redirect:/category/list_category";
    }

    @GetMapping("/{id}/category/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.findById(id));
        return "category/edit";
    }
}
