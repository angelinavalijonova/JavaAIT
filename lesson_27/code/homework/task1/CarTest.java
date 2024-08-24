package homework.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CarTest {

    Car[] cars;

    @BeforeEach
    void setUp() {
        cars = new Car[3];
        cars[0] = new Car("BMW","White",100,2000);
        cars[1] = new Car("Mercedes","Red",200,2010);
        cars[2] = new Car("Ford","Black",300,2020);

    }

    @Test
    void testSortByYear(){ //using comparable
        printCars(cars);
        Arrays.sort(cars);
        printCars(cars);
    }

     @Test
     void testSortByPrice(){
        printCars(cars);
        Comparator<Car> comparatorByPrice = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return - Double.compare(car1.getPrice(),car2.getPrice());
            }
        };
        Arrays.sort(cars,comparatorByPrice);
        printCars(cars);
     }

    @Test
    void  testSortByBrand(){//using comparator
        printCars(cars);

        Comparator<Car> comparatorByBrand = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getBrand().compareTo(car2.getBrand());
            }
        };
        Arrays.sort(cars,comparatorByBrand);
        printCars(cars);
    }

    @Test
    void  testSortColor(){
        printCars(cars);

        Comparator<Car> comparatorByColor = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getColor().compareTo(car2.getColor());
            }
        };
        Arrays.sort(cars,comparatorByColor);
        printCars(cars);
    }

    public void printCars(Object[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("----------------------");
    }
}