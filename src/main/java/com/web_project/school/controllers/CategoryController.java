package com.web_project.school.controllers;

import com.web_project.school.model.CategoryModel;
import com.web_project.school.model.HolidayModel;
import com.web_project.school.service.BookService;
import com.web_project.school.service.CategoryService;
import com.web_project.school.service.HolidayService;
import com.web_project.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @Autowired
    public BookService bookService;

    @GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("category", new CategoryModel());
        model.addAttribute("books", bookService.findAllBook());

        return "categoryList";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAllCategory());
            model.addAttribute("books", bookService.findAllBook());
            return "categoryList";
        }
        categoryService.addCategory(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result) {
        categoryService.updateCategory(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/delete")
    public String deleteHoliday(@RequestParam UUID id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories/all";
    }

    @GetMapping("/all/{id}")
    public String deleteCategory(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("categories", categoryService.findCategoryById(id));
        model.addAttribute("category", new CategoryModel());
        model.addAttribute("books", bookService.findAllBook());
        return "categoryList";
    }


}
