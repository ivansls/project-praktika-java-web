package com.web_project.school.controllers;

import com.web_project.school.model.CategoryModel;
import com.web_project.school.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/categories")
public class CategoryApiController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<CategoryModel> deleteCategory() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryModel getCategoryById(@PathVariable UUID id){
        return categoryService.findCategoryById(id);
    }

    @PostMapping
    public CategoryModel createCategory(@RequestBody CategoryModel author){
        return categoryService.addCategory(author);
    }

    @PutMapping("/{id}")
    public CategoryModel updateCategory(@PathVariable UUID id, @RequestBody CategoryModel author){
        author.setId(id);
        return categoryService.updateCategory(author);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable UUID id){
        categoryService.deleteCategory(id);
    }
}
