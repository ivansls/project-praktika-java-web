package com.web_project.school.controllers;


import com.web_project.school.model.RoleEnum;
import com.web_project.school.model.UserModel;
import com.web_project.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationView() {
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(UserModel user, Model model) {
        if(userRepository.existsByUsername(user.getUsername())){
            model.addAttribute("message", "user already exists");
            return "regis";
        }
        user.setActive(true);
        user.setRole(Collections.singleton(RoleEnum.USER).toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}