package com.maialieg;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public boolean isFoodAvailableAtMealTime(String foodName, MealTime mealTime) {
        return foodRepository.getFood(mealTime).stream()
                .anyMatch(food -> food.getName().equals(foodName));
    }

    public void addFood(String foodName, Integer calories, MealTime mealTime) {
        foodRepository.addFood(mealTime, new FoodData(foodName, calories));
    }

    public Map<MealTime, List<FoodData>> getAllFoodByMealTime() {
        Map<MealTime, List<FoodData>> result = new LinkedHashMap<>();
        for (MealTime mealTime : MealTime.values()) {
            result.put(mealTime, foodRepository.getFood(mealTime));
        }
        return result;
    }
}