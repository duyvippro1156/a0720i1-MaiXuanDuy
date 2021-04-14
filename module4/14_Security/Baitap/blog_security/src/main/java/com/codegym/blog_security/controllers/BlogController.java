package com.codegym.blog_security.controllers;

import com.codegym.blog_security.models.Blog;
import com.codegym.blog_security.models.Category;
import com.codegym.blog_security.services.BlogService;
import com.codegym.blog_security.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> getListCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView getList(@RequestParam(required = false) String sortDirection,
                                @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int id,
                                @RequestParam(required = false) String s) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Blog> blogPage;
        sortDirection = sortDirection == null ? "desc" : sortDirection;
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("createdTime").ascending() : Sort.by("createdTime").descending();
        Pageable pageableSort = PageRequest.of(page, 3, sort);
        if (id == 0) {
            if(s != null) {
                blogPage = blogService.findAllByTitleContaining(s, pageableSort);
            }else {
                blogPage = blogService.findAll(pageableSort);
            }
        } else {
            if(s != null) {
                blogPage = blogService.findAllByTitleContainingAndCategory_Id(s,id, pageableSort);
            }else {
                blogPage = blogService.findAllByCategory(id, pageableSort);
            }
        }
        modelAndView.addObject("id", id);
        modelAndView.addObject("blogs", blogPage);
        modelAndView.addObject("sortDirection", sortDirection);
        modelAndView.addObject("s", s);
        return modelAndView;
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
