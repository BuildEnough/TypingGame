package com.example.TypingGame.controller;

import com.example.TypingGame.dto.ArticleForm;
import com.example.TypingGame.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        Article article = articleForm.toEntity(); // articleform 객체의 toEntity() 메서드 호출
        return "";
    }
}
