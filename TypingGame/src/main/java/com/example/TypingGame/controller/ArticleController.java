package com.example.TypingGame.controller;

import com.example.TypingGame.dto.ArticleForm;
import com.example.TypingGame.entity.Article;
import com.example.TypingGame.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        log.info(articleForm.toString());

        Article article = articleForm.toEntity(); // articleform 객체의 toEntity() 메서드 호출
        log.info(article.toString());

        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        log.info(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> articleEntityList = articleRepository.findAll(); // ArrayList 대신 List로 업캐스팅

        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }
}
