package com.codegym.validate.Controller;

import com.codegym.validate.Model.User;
import com.codegym.validate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ModelAndView getForm() {
        return new ModelAndView("index", "user", new User());
    }
    @PostMapping("/result")
    public String result(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        userService.save(user);
        return "result";
    }

}
