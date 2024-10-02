package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Brand;
    @Size(min = 3, message = "Color size error")
    private String Color;
    private String Model;
    private boolean IsExist;

    public CarModel(Long id, String brand, String color, String model, boolean isExist) {
        Id = id;
        Brand = brand;
        Color = color;
        Model = model;
        IsExist = isExist;
    }

    public CarModel() {

    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public @Size(min = 3, message = "Color size error") String getColor() {
        return Color;
    }

    public void setColor(@Size(min = 3, message = "Color size error") String color) {
        Color = color;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public boolean isExist() {
        return IsExist;
    }

    public void setExist(boolean exist) {
        IsExist = exist;
    }
}
