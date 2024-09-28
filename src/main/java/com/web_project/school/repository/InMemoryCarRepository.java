//package com.web_project.school.repository;
//
//import com.web_project.school.model.CarModel;
//import com.web_project.school.model.StudentModel;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryCarRepository {
//    private List<CarModel> cars = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1);
//
//
//    public List<CarModel> findAllCars() {
//        return cars.stream()
//                .filter(car -> !car.isExist())
//                .collect(Collectors.toList());
//
//    }
//
//    public CarModel addCar(CarModel car) {
//        car.setId(idCounter.getAndIncrement());
//        cars.add(car);
//        return car;
//    }
//
//    public CarModel updateCar(CarModel car) {
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getId() == car.getId()){
//                cars.set(i, car);
//                return car;
//            }
//        }
//        return null;
//    }
//
//
//    public void deleteLogicCar(int id) {
//        for (CarModel guest : cars) {
//            if (guest.getId() == id) {
//                guest.setExist(true);
//                break;
//            }
//        }
//    }
//
//    public void deleteCar(int id){
//        cars.removeIf(car -> car.getId() == id);
//    }
//
//    public CarModel findCarById(int id){
//        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
//    }
//
//
//
//
//}
