package com.web_project.school.controllers;

import com.web_project.school.model.CarModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    public CarService carService;


    @GetMapping("/all")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.findAllCars());
        return "carList";
    }

    @PostMapping("/add")
    public String addCars(@RequestParam String Brand,
                             @RequestParam String Color,
                             @RequestParam String Model) {
        CarModel newCar = new CarModel(0, Brand, Color, Model);
        carService.addCar(newCar);
        return "redirect:/cars/all";
    }

    @PostMapping("/update")
    public String updateCar(@RequestParam int id,
                                @RequestParam String Brand,
                                @RequestParam String Color,
                                @RequestParam String Model) {
        CarModel updateCar = new CarModel(id, Brand, Color, Model);
        carService.updateCar(updateCar);
        return "redirect:/cars/all";
    }

    @PostMapping("/delete")
    public String deleteCar(@RequestParam int id) {
        carService.deleteCar(id);
        return "redirect:/cars/all";
    }


    @PostMapping("/logic_delete")
    public String logicDeleteCar(@RequestParam int id) {
        carService.deleteLogicCar(id);
        return "redirect:/cars/all";
    }

    @GetMapping("/all/{id}")
    public String getIdCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("cars", carService.findCarById(id));
        return "carList";
    }


    @GetMapping("/search")
    public String searchGuest(@RequestParam(required = false) String brand,
                              @RequestParam(required = false) String modell,
                              Model model) {
        if (brand != null && !brand.isEmpty() && modell != null && !modell.isEmpty()) {
            model.addAttribute("cars", carService.findCarsByBrandAndModel(brand, modell));
        } else if (brand != null && !brand.isEmpty()) {
            model.addAttribute("cars", carService.findCarsByBrand(brand));
        } else if (modell != null && !modell.isEmpty()) {
            model.addAttribute("cars", carService.findCarsByModel(modell));
        } else {
            model.addAttribute("cars", carService.findAllCars());
        }
        return "carList";
    }
}
