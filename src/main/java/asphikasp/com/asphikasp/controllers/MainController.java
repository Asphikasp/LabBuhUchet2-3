package asphikasp.com.asphikasp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", "Za Warudo");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("text", "ORORORORORO");
        return "about";
    }
}