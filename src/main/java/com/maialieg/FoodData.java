package com.maialieg;

public class FoodData {

    private final String name;
    private final Integer calories;

    public FoodData(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }
}