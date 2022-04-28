package com.example.module06modelattributeannotation.service;

import com.example.module06modelattributeannotation.dao.ArticleDao;
import com.example.module06modelattributeannotation.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public List<Article> findAll() {
        return articleDao.findAll();
    }

    public void save(Article article) {
        if(article.getId() == 0) {
            this.articleDao.save(article);
        }else {
            Article a = findById(article.getId());
            a.setName(article.getName());
            this.articleDao.save(a);
        }
    }

    public Article findById(int id) {
        return this.articleDao.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        this.articleDao.deleteById(id);
    }
}
