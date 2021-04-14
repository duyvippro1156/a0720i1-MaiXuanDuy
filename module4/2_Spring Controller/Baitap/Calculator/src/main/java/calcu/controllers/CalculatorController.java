package calcu.controllers;

import calcu.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {
    @Autowired
   private CalculatorService calculatorService;

    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }

    @PostMapping("/result")
    public String getResult(@RequestParam double number1, @RequestParam double number2, @RequestParam String operator, Model model) throws Exception {
        try {
            double result = calculatorService.calculate(number1, number2, operator);
            model.addAttribute("result", result);
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("operator", operator);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }

}
