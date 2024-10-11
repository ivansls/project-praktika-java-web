package com.web_project.school.controllers;


import com.web_project.school.model.ProfileModel;
import com.web_project.school.model.UsersModel;
import com.web_project.school.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
public class UsersController {
    @Autowired
    public UsersService usersService;



    @GetMapping("/all")
    public String getAllUser(Model model) {
        model.addAttribute("users", usersService.findAllUsers("ALL"));
        model.addAttribute("user", new UsersModel());
        return "userList";
    }

    @PostMapping("/add")
    public String addAllUser(@Valid @ModelAttribute("user") UsersModel user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", usersService.findAllUsers("ALL"));
            return "userList";
        }
        ProfileModel profile = user.getProfile();
        user.setProfile(profile);
        user.setActive(true);
        usersService.addUser(user);
        return "redirect:/users/all";
    }

    @PostMapping("/update")
    public String updatUser(@Valid @ModelAttribute("user") UsersModel user, BindingResult result) {
        usersService.updateUser(user);
        return "redirect:/users/all";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam UUID id) {
        usersService.deleteUser(id);
        return "redirect:/users/all";
    }

    @GetMapping("/all/{id}")
    public String getIdUser(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("users", usersService.findUserById(id));
        return "userList";
    }
}
