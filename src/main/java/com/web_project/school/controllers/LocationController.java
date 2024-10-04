package com.web_project.school.controllers;

import com.web_project.school.model.BookModel;
import com.web_project.school.model.LocationModel;
import com.web_project.school.model.PassportModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.BookService;
import com.web_project.school.service.LocationService;
import com.web_project.school.service.StudentService;
import com.web_project.school.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    public LocationService locationService;
    @Autowired
    public BookService bookService;
    @GetMapping("/all")
    public String getAllLocation(Model model) {
        model.addAttribute("locations", locationService.findAllLocation());
        model.addAttribute("location", new LocationModel());
        model.addAttribute("books", bookService.findAllBook());
        return "locationList";
    }
    @PostMapping("/add")
    public String addLocation(@Valid @ModelAttribute("location") LocationModel location, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("locations", locationService.findAllLocation());
            model.addAttribute("books", bookService.findAllBook());
            return "locationList";
        }
        locationService.addLocation(location);
        return "redirect:/locations/all";
    }
    @PostMapping("/update")
    public String updateLocation(@Valid @ModelAttribute("location") LocationModel location, BindingResult result) {
        locationService.updateLocation(location);
        return "redirect:/locations/all";
    }
    @PostMapping("/delete")
    public String deleteLocation(@RequestParam UUID id) {
        locationService.deleteLocation(id);
        return "redirect:/locations/all";
    }
    @GetMapping("/all/{id}")
    public String getIdLocation(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("locations", locationService.findLocationById(id));
        model.addAttribute("location", new LocationModel());
        model.addAttribute("books", bookService.findAllBook());
        return "locationList";
    }
}
