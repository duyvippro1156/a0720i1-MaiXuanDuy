package com.codegym.casestudy.controller;

import com.codegym.casestudy.models.user_role.Users;
import com.codegym.casestudy.sevices.employee.EmployeeService;
import com.codegym.casestudy.sevices.user_role.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class MainController {
    @Autowired
    UsersService usersService;

    @Autowired
    EmployeeService employeeService;

//    @ModelAttribute("searchUri")
//    public String getCurrentUri(HttpServletRequest request) {
//        return "@{/" + request.getRequestURI() + "}";
//    }

    @GetMapping("/")
    public String viewHomePage(@ModelAttribute("user") Users users) {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
//        Edit after learning Spring security lesson
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "403-page";
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String sqlDeleteHandler(){
        return "sql-error-page";
    }

    @ExceptionHandler(Exception.class)
    public String viewErrorPage() {
        return "error-page";
    }


}
