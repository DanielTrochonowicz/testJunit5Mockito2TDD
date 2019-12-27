package unitTestJava.order;

import unitTestJava.meal.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals = new ArrayList<>();

    public void addMealToOrder(Meal meal){
        this.meals.add(meal);
    }
    public void removeMealToOrder(Meal meal){
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    void canel(){
        this.meals.clear();
    }

    int totalPrice(){

        int sum = this.meals.stream().mapToInt(meals -> meals.getPrice()).sum();
        if (sum < 0){
            throw new IllegalStateException("Price limit exceeded");
        }else {
            return sum;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}