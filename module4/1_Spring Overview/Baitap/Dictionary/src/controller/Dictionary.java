package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    static Map<String, String> dictionary = new HashMap();

    static {
        dictionary.put("banana", "trái chuối");
        dictionary.put("apple", "trái táo");
        dictionary.put("watermelon", "trái dưa hấu");
        dictionary.put("dragon fruit", "trái thanh long");
        dictionary.put("pineapple", "trái thơm");
    }

    @GetMapping(value = "/search")
    public ModelAndView viewSearch() {
        return new ModelAndView("dictionary");
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam String word, Model model) {
        String english = word.trim().toLowerCase();
        String vietnamese = dictionary.get(english);
        model.addAttribute("english", english);
        if (vietnamese != null) {
            model.addAttribute("vietnamese", vietnamese);
        } else {
            model.addAttribute("vietnamese", "Không tìm thấy");
        }
        return "dictionary";
    }
}
