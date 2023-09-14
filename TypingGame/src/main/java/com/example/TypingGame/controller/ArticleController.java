package com.example.TypingGame.controller;

import com.example.TypingGame.dto.ArticleForm;
import com.example.TypingGame.entity.Article;
import com.example.TypingGame.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        System.out.println(articleForm.toString());

        Article article = articleForm.toEntity(); // articleform 객체의 toEntity() 메서드 호출
        System.out.println(article.toString());

        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        System.out.println(saved.toString());
        return "";
    }
}
