package controllers;

import models.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/")
    public ModelAndView getHomepage() {
        return new ModelAndView("index", "sandwich", new Sandwich());
    }

    @PostMapping("/sandwich")
    String showCondiments(@ModelAttribute Sandwich sandwich, Model model) {
        model.addAttribute("sandwich", sandwich);
        return "condiment";
    }
}
