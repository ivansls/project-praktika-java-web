package com.web_project.school.model;

import jakarta.annotation.Nullable;

public class CarModel {
    private int Id;
    private String Brand;
    private String Color;
    private String Model;
    private boolean IsExist;

    public CarModel(int id, String brand, String color, String model) {
        Id = id;
        Brand = brand;
        Color = color;
        Model = model;
        IsExist = false;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Nullable
    public String getModel() {
        return Model;
    }

    public void setModel(@Nullable String model) {
        Model = model;
    }

    public boolean isExist() {
        return IsExist;
    }

    public void setExist(boolean exist) {
        IsExist = exist;
    }
}
