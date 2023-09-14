package com.example.TypingGame.dto;

import com.example.TypingGame.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
