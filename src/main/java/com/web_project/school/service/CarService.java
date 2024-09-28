package com.web_project.school.service;

import com.web_project.school.model.CarModel;

import java.util.List;

public interface CarService {
    //public void deleteLogicCar(Long id);
    public List<CarModel> findAllCars();
    public CarModel addCar(CarModel car);
    public CarModel updateCar(CarModel car);
    public void deleteCar(Long id);
    public CarModel findCarById(Long id);

    List<CarModel> findCarsByBrandAndModel(String brand, String model);

    List<CarModel> findCarsByBrand(String brand);

    List<CarModel> findCarsByModel(String model);
}
