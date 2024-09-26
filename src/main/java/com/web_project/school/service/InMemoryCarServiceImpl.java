package com.web_project.school.service;

import com.web_project.school.model.CarModel;
import com.web_project.school.repository.InMemoryCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryCarServiceImpl implements CarService{
    private final InMemoryCarRepository carRepository;

    public InMemoryCarServiceImpl(InMemoryCarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarModel> findAllCars(){
        return carRepository.findAllCars();
    }
    @Override
    public CarModel addCar(CarModel car){
        return carRepository.addCar(car);
    }

    @Override
    public CarModel updateCar(CarModel car){
        return carRepository.updateCar(car);
    }

    @Override
    public void deleteCar(int id){
        carRepository.deleteCar(id);
    }

    @Override
    public CarModel findCarById(int id){
        return carRepository.findCarById(id);
    }

    @Override
    public void deleteLogicCar(int id){
        carRepository.deleteLogicCar(id);
    }

    @Override
    public List<CarModel> findCarsByBrandAndModel(String brand, String model) {
        return carRepository.findAllCars().stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarModel> findCarsByBrand(String brand) {
        return carRepository.findAllCars().stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarModel> findCarsByModel(String model) {
        return carRepository.findAllCars().stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }
}
