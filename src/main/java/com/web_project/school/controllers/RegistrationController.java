package com.web_project.school.controllers;

import com.web_project.school.model.RoleEnum;
import com.web_project.school.model.UsersModel;
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
    public String registrationView(){
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(UsersModel user, Model model){
        if (userRepository.existsByUsername(user.getUsername())){
            model.addAttribute("message", "Пользователь уже существует");
            return "regis";
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            model.addAttribute("message", "Пароль должен содержать не менее 8 символов");
            return "regis";
        }


        if (!user.getPassword().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$")) {
            model.addAttribute("message", "Пароль должен содержать хотя бы одну букву, одну цифру и один специальный символ (@#$%^&+=!)");
            return "regis";
        }

        if(!user.getEmail().matches("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)")){
            model.addAttribute("message", "Емеил не корректен");
            return "regis";
        }
        




        user.setActive(true);
        user.setEmail(user.getEmail());
        user.setProfile(user.getProfile());
        user.setRoles(Collections.singleton(RoleEnum.STUDENT));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

}
