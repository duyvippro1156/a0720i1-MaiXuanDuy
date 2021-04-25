package com.codegym.blog_authen.controllers;

import com.codegym.blog_authen.models.Blog;
import com.codegym.blog_authen.models.Users;
import com.codegym.blog_authen.models.Category;
import com.codegym.blog_authen.services.BlogService;
import com.codegym.blog_authen.services.CategoryService;
import com.codegym.blog_authen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

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
    public String save(@ModelAttribute Blog blog, Principal principal) {
        if (blog.getId() == 0) {
            blog.setCreatedTime(LocalDate.now());
        }
        if (blog.getUsers() == null) {
            String email = principal.getName();
            Users users = userService.findUserByEmail(email);
            blog.setUsers(users);
        }
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Principal principal) {
        Blog blog = blogService.findById(id);
        User loginedUsers = (User) ((Authentication) principal).getPrincipal();
        if (loginedUsers.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || principal.getName().equals(blog.getUsers().getEmail())) {
            blogService.remove(id);
            return "redirect:/";
        } else {
            return "redirect:/403";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model, Principal principal) {
        Blog blog = blogService.findById(id);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        if (loginedUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || principal.getName().equals(blog.getUsers().getEmail())) {
            model.addAttribute("blog", blog);
            return "edit";
        } else {
            return "redirect:/403";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403";
    }

}
