package com.web_project.school.controllers;


import com.web_project.school.model.CarModel;
import com.web_project.school.model.MusicModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    public MusicService musicService;
    @GetMapping("/all")
    public String getAllMusic(Model model) {
        model.addAttribute("musics", musicService.findAllMusic());
        model.addAttribute("music", new MusicModel());
        return "musicList";
    }
    @PostMapping("/add")
    public String addMusic(@Valid @ModelAttribute("student") MusicModel music, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("musics", musicService.findAllMusic());
            return "musicList";
        }
        musicService.addMusic(music);
        return "redirect:/musics/all";
    }
    @PostMapping("/update")
    public String updateMusic(@Valid @ModelAttribute("student") MusicModel music, BindingResult result) {
        musicService.updateMusic(music);
        return "redirect:/musics/all";
    }
    @PostMapping("/delete")
    public String deleteCar(@RequestParam Long id) {
        musicService.deleteMusic(id);
        return "redirect:/musics/all";
    }
    @GetMapping("/all/{id}")
    public String getIdCar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("musics", musicService.findMusicById(id));
        model.addAttribute("music", musicService.findAllMusic());
        return "musicList";
    }
    @GetMapping("/search")
    public String musicSort(@RequestParam String author, Model model) {
        model.addAttribute("musics", musicService.MusicSort(author));
        model.addAttribute("music", new MusicModel());
        return "musicList";
    }
    @GetMapping("/search_album")
    public String musicSortAlbum(@RequestParam String author, Model model) {
        model.addAttribute("musics", musicService.musicSortAlbum(author));
        model.addAttribute("music", new MusicModel());
        return "musicList";
    }
}
