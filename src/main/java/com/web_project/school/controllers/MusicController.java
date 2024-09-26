package com.web_project.school.controllers;


import com.web_project.school.model.CarModel;
import com.web_project.school.model.MusicModel;
import com.web_project.school.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    public MusicService musicService;


    @GetMapping("/all")
    public String getAllMusic(Model model) {
        model.addAttribute("musics", musicService.findAllMusic());
        return "musicList";
    }

    @PostMapping("/add")
    public String addMusic(@RequestParam String Name,
                          @RequestParam String Author,
                          @RequestParam String Album) {
        MusicModel newMusic = new MusicModel(0, Name, Author, Album);
        musicService.addMusic(newMusic);
        return "redirect:/musics/all";
    }

    @PostMapping("/update")
    public String updateMusic(@RequestParam int id,
                            @RequestParam String Name,
                            @RequestParam String Author,
                            @RequestParam String Album) {
        MusicModel updateMusic = new MusicModel(id, Name, Author, Album);
        musicService.updateMusic(updateMusic);
        return "redirect:/musics/all";
    }

    @PostMapping("/delete")
    public String deleteCar(@RequestParam int id) {
        musicService.deleteMusic(id);
        return "redirect:/musics/all";
    }

    @GetMapping("/all/{id}")
    public String getIdCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("musics", musicService.findMusicById(id));
        return "musicList";
    }
}
