package com.web_project.school.controllers;

import com.web_project.school.model.CarModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    public CarService carService;
    @GetMapping("/all")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.findAllCars());
        model.addAttribute("car", new CarModel());
        return "carList";
    }
    @PostMapping("/add")
    public String addCars(@Valid @ModelAttribute("car") CarModel car, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("cars", carService.findAllCars());
            return "studentList";
        }
        carService.addCar(car);
        return "redirect:/cars/all";
    }
    @PostMapping("/update")
    public String updateCar(@Valid @ModelAttribute("car") CarModel car, BindingResult result) {
        carService.updateCar(car);
        return "redirect:/cars/all";
    }
    @PostMapping("/delete")
    public String deleteCar(@RequestParam Long id) {
        carService.deleteCar(id);
        return "redirect:/cars/all";
    }
    @PostMapping("/logic_delete")
    public String logicDeleteCar(@RequestParam Long id) {
        List<CarModel> cars = carService.findAllCars();
        for (CarModel car : cars) {
            if (Objects.equals(car.getId(), id)) {
                car.setExist(true);
                carService.updateCar(car);
                break;
            }
        }
        return "redirect:/cars/all";
    }
    @GetMapping("/all/{id}")
    public String getIdCar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cars", carService.findCarById(id));
        model.addAttribute("car", new CarModel());
        return "carList";
    }
    @GetMapping("/search")
    public String searchGuest(@RequestParam(required = false) String brand,
                              @RequestParam(required = false) String modell,
                              Model model) {
        if (brand != null && !brand.isEmpty() && modell != null && !modell.isEmpty()) {
            model.addAttribute("cars", carService.findCarsByBrandAndModel(brand, modell));
            model.addAttribute("car", new CarModel());
        } else if (brand != null && !brand.isEmpty()) {
            model.addAttribute("cars", carService.findCarsByBrand(brand));
            model.addAttribute("car", new CarModel());
        } else if (modell != null && !modell.isEmpty()) {
            model.addAttribute("cars", carService.findCarsByModel(modell));
            model.addAttribute("car", new CarModel());
        } else {
            model.addAttribute("cars", carService.findAllCars());
            model.addAttribute("car", new CarModel());
        }
        return "carList";
    }
}
