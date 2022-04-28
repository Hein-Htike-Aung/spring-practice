package com.example.module06modelattributeannotation.controller;

import com.example.module06modelattributeannotation.entity.Article;
import com.example.module06modelattributeannotation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ModelAttributeController {

    @Autowired
    private ArticleService articleService;

    @ModelAttribute("articles")
    public List<Article> findAll() {
        return this.articleService.findAll();
    }

    @GetMapping({"/", "/index"})
    public String index(
            @ModelAttribute Article article,
            @ModelAttribute("articles") List<Article> articleList) {

        return "index";
    }

    @PostMapping("/article/save")
    public String saveArticle(
            @Valid Article article,
            BindingResult bindingResult,
            @ModelAttribute("articles") List<Article> articleList) {

        if(bindingResult.hasErrors()){

            return "/index";
        }
        this.articleService.save(article);
        return "redirect:/index";
    }

    @PostMapping("/article/update")
    public String updateArticle(
            @PathParam("id") int id,
            Model model,
            @ModelAttribute("articles") List<Article> articleList
    ){
        model.addAttribute("article", this.articleService.findById(id));

        return "/index";
    }

    @PostMapping("/article/delete/{delete}")
    public String deleteArticle(
            @PathVariable("delete") int id
    ){
        this.articleService.deleteById(id);

        return "redirect:/index";
    }



}
