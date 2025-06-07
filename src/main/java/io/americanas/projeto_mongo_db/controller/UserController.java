package io.americanas.projeto_mongo_db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to Thymeleaf!");
//        model.addAttribute("names", List.of("Alice", "Bob", "Charlie"));
//        model.addAttribute("user", new User());
        return "index";
    }
}
