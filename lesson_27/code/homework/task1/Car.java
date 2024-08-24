package homework.task1;

import java.util.Objects;

//На примере класса Car с полями бренд, цвет, стоимость, год выпуска повторить все то,
// что делали с классом Wine на занятии.
public class Car implements Comparable<Car>{

    public String brand;
    public String color;
    public double price;
    public int year;

    public Car(String brand, String color, double price, int year) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && year == car.year && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price, year);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", price=").append(price);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Car car) {
        int year =  - (this.getYear()-car.getYear());
        return year;
    }
}
