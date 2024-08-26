package homework;

import java.util.Objects;

public class Food implements Comparable<Food> {

    private String meal;
    private int calories;
    private double price;

    public Food(String meal, int calories, double price) {
        this.meal = meal;
        this.calories = calories;
        this.price = price;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return calories == food.calories && Double.compare(price, food.price) == 0 && Objects.equals(meal, food.meal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meal, calories, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Food{");
        sb.append("meal='").append(meal).append('\'');
        sb.append(", calories=").append(calories);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.calories,o.calories);
    }
}
