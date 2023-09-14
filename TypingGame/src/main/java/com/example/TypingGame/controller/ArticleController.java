package com.example.TypingGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/new")
    public String newArticleForm() {
        return "articles/new";
    }
}
