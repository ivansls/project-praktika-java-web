package com.web_project.school.service;

import com.web_project.school.model.CarModel;
import com.web_project.school.repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;

@Service
public class InMemoryCarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public InMemoryCarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarModel> findAllCars(){
        return (List<CarModel>) carRepository.findAll(Sort.by("id")).stream()
                .filter(car -> !car.isExist())
                .collect(Collectors.toList());
    }
    @Override
    public CarModel addCar(CarModel car){
        return carRepository.save(car);
    }

    @Override
    public CarModel updateCar(CarModel car){
        return carRepository.save(car);
    }




    @Override
    public void deleteCar(Long id){
        if(carRepository.existsById(id)) carRepository.deleteById(id);
    }

    @Override
    public CarModel findCarById(Long id){
        return carRepository.findById(id).orElse(null);
    }

//    @Override
//    public void deleteLogicCar(Long id){
//        carRepository.save(id);
//    }

    @Override
    public List<CarModel> findCarsByBrandAndModel(String brand, String model) {
        return carRepository.findAll(Sort.by("id")).stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarModel> findCarsByBrand(String brand) {
        return carRepository.findAll(Sort.by("id")).stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarModel> findCarsByModel(String model) {
        return carRepository.findAll(Sort.by("id")).stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }
}
