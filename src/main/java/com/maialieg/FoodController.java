package com.maialieg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/food")
@Controller
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String getFoodForm(FoodForm foodForm, Model model) {
        model.addAttribute("mealTimes", MealTime.values());
        return "food";
    }

    @PostMapping
    public String addFood(FoodForm foodForm, Model model) {
        foodService.addFood(foodForm.getFoodName(), foodForm.getCalories(), foodForm.getMealTime());
        model.addAttribute("mealTimes", MealTime.values());
        model.addAttribute("message", "'" + foodForm.getFoodName() + "' added successfully!");
        return "food";
    }

    @GetMapping("/list")
    public String getFoodList(Model model) {
        model.addAttribute("mealTimes", MealTime.values());
        model.addAttribute("foodByMealTime", foodService.getAllFoodByMealTime());
        return "foodList";
    }
}