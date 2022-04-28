package com.example.module12mvccrudmultipagesmultitables.controller;

import com.example.module12mvccrudmultipagesmultitables.entity.Category;
import com.example.module12mvccrudmultipagesmultitables.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    private List<Category> categoryList() {
        return this.categoryService.findAll(null);
    }

    @GetMapping({"/", "/index", "/categories"})
    public String index(
            @Param("name") String name,
            Model model
    ) {
        model.addAttribute("categories", this.categoryService.findAll(name));
        model.addAttribute("category", new Category());

        return "/index";
    }

    @PostMapping("/category/save")
    public String save(
            @Valid Category category,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        this.categoryService.saveCategory(category);
        return "redirect:/index";
    }

    @PostMapping("/category/delete")
    public String delete(
            @RequestParam("id") int id
    ) {
        this.categoryService.deleteById(id);

        return "redirect:/index";
    }

    @PostMapping("/category/update")
    public String update(
            @RequestParam("id") int id,
            @ModelAttribute("categories") List<Category> categoryList,
            Model model
    ) {
        model.addAttribute("category", this.categoryService.findById(id));
        return "/index";
    }

    @GetMapping("/category/details")
    public String viewProducts(
            @RequestParam("id") int id,
            Model model
    ) {

        model.addAttribute("category", this.categoryService.findById(id));

        return "/category-details";
    }

}
