package com.maialieg;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FoodRepository {

    private final Map<MealTime, List<FoodData>> foodMap = new HashMap<>();

    public FoodRepository() {
        for (MealTime mealTime : MealTime.values()) {
            foodMap.put(mealTime, new ArrayList<>());
        }
    }

    public List<FoodData> getFood(MealTime mealTime) {
        return foodMap.getOrDefault(mealTime, new ArrayList<>());
    }

    public void addFood(MealTime mealTime, FoodData foodData) {
        foodMap.get(mealTime).add(foodData);
    }
}