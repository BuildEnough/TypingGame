package com.example.TypingGame.repository;

import com.example.TypingGame.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
