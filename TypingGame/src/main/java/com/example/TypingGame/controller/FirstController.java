package com.example.TypingGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/index")
    public String game() {
        return "index";
    }
}
