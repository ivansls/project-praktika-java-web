package com.web_project.school.service;

import com.web_project.school.model.CarModel;

import java.util.List;

public interface CarService {
    public void deleteLogicCar(int id);
    public List<CarModel> findAllCars();
    public CarModel addCar(CarModel car);
    public CarModel updateCar(CarModel car);
    public void deleteCar(int id);
    public CarModel findCarById(int id);

    List<CarModel> findCarsByBrandAndModel(String brand, String model);

    List<CarModel> findCarsByBrand(String brand);

    List<CarModel> findCarsByModel(String model);
}
