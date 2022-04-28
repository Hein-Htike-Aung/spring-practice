package com.example.module12mvccrudmultipagesmultitables.controller;

import com.example.module12mvccrudmultipagesmultitables.entity.Category;
import com.example.module12mvccrudmultipagesmultitables.entity.Product;
import com.example.module12mvccrudmultipagesmultitables.service.CategoryService;
import com.example.module12mvccrudmultipagesmultitables.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    private List<Category> categories() {
        return this.categoryService.findAll(null);
    }

    @GetMapping("/products")
    private String products(
            Model model,
            @Param("keyword") String keyword
    ) {
        model.addAttribute("products", this.productService.findAll(keyword));

        return "/products";
    }

    @GetMapping("/products/add")
    public String addNew(
            Model model,
            @ModelAttribute("categories") List<Category> categoryList
    ) {
        model.addAttribute("product", new Product());
        return "/product-form";
    }

    @PostMapping("/products/save")
    public String save(
            @Valid Product product,
            BindingResult bindingResult
    ) {
        if(product.getCategory() == null) {
            bindingResult.rejectValue("category","", "");
        }
        if (bindingResult.hasErrors()) {
            return "/product-form";
        }

        this.productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/update")
    public String update(
            @RequestParam("id") int id,
            @ModelAttribute("categories") List<Category> categoryList,
            Model model
    ) {
        model.addAttribute("product", this.productService.findById(id));
        return "/product-form";
    }

    @PostMapping("/products/delete/{id}")
    public String delete(
            @PathVariable("id") int id
    ) {

        this.productService.deleteById(id);

        return "redirect:/products";
    }
}
