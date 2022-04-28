package com.example.module06modelattributeannotation.dao;

import com.example.module06modelattributeannotation.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
}
