# Food Tracking Service

A Spring Boot web application for tracking daily food intake with meal time categorization.

## Overview
A full-stack web application built with Spring Boot and Thymeleaf that allows users
to track food items by name, calories, and meal time. Demonstrates the complete
Spring MVC layered architecture with a working web UI.

## Features
- Add food items with name and calorie information
- Categorize food by meal time (BREAKFAST, LUNCH, DINNER)
- View all food items grouped by meal time
- Calculate total calories per meal
- Clean layered architecture (Controller → Service → Repository)
- Spring dependency injection throughout

## Architecture

| Class | Responsibility |
|---|---|
| `FoodController` | Handles GET/POST HTTP requests via Spring MVC |
| `FoodService` | Business logic and food management |
| `FoodRepository` | In-memory data storage with meal time grouping |
| `FoodData` | Food entity model (name, calories) |
| `FoodForm` | Form binding for incoming requests |
| `MealTime` | Enum for meal categorization (BREAKFAST, LUNCH, DINNER) |
| `FoodTrackingApplication` | Spring Boot entry point |

## Tech Stack
Java 11 · Spring Boot 2.2.7 · Spring MVC · Thymeleaf · Maven

## Running

~~~bash
mvn spring-boot:run
~~~

Then open your browser at:
~~~
http://localhost:8080/food
~~~

## Endpoints

| Method | Path | Description |
|---|---|---|
| GET | /food | Show add food form |
| POST | /food | Submit new food item |
| GET | /food/list | View all food grouped by meal time |

## Screenshots

### Add Food
Navigate to `http://localhost:8080/food` to add a food item:
- Enter food name
- Enter calories
- Select meal time (BREAKFAST, LUNCH, DINNER)
- Click Add Food

### View Food List
Navigate to `http://localhost:8080/food/list` to see all food items
grouped by meal time with total calories per meal.

## What I would add in a production system
- PostgreSQL database with Spring Data JPA instead of in-memory storage
- User authentication with Spring Security
- REST API endpoints returning JSON in addition to the web UI
- Input validation with Bean Validation (@NotNull, @Min, @Max)
- Unit and integration tests with MockMvc