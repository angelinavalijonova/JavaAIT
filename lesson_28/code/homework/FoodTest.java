package homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    Food[] foods;

    @BeforeEach
    void setUp() {
        foods = new Food[]{
                new Food("Smashed Potato",500,8),
                new Food("Lasagna",800,15),
                new Food("Dumplings",800,11),
                new Food("Burger",700,10),
                new Food("Avocado Tost",200,12)
        };
    }
    @Test
    void testSortByCaloriesComparable(){
        printArray(foods);
        Arrays.sort(foods);
        printArray(foods);
    }

    @Test
    void testSortByName(){ // with lambda
        printArray(foods);
        Arrays.sort(foods,(f1,f2) -> f1.getMeal().compareTo(f2.getMeal()));
        printArray(foods);
    }

    @Test
    void testSortByCaloriesAndPrice(){ // NOT WORKING ??
//        printArray(foods);
//        Arrays.sort(foods,(f1,f2) -> {
//            int res =  (f1.getCalories()-f2.getCalories());
//            return res != 0 ? res : -(int)(f1.getPrice() - f2.getPrice());
//        });
//        printArray(foods);
        printArray(foods);
        Arrays.sort(foods,(f1,f2) -> Double.compare(f1.getPrice(),f2.getPrice()));
        printArray(foods);
    }
    @Test
    void testSortByCaloriesAndPriceWithComparator(){
        printArray(foods);
        Arrays.sort(foods,(f1,f2) -> f1.getCalories()-f2.getCalories());
        printArray(foods);

        Comparator<Food> comparatorByPriceAndCalories = new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                int res = Integer.compare(f1.getCalories(),f2.getCalories());
                return res != 0 ? res : Double.compare(f1.getPrice(),f2.getPrice());
            }
        };
        Arrays.sort(foods,comparatorByPriceAndCalories);
        printArray(foods);

    }

    @Test
    void testArraysBinarySearch (){
        printArray(foods);
        Arrays.sort(foods,(f1,f2)-> f1.getCalories() - f2.getCalories());
        printArray(foods);
        Food pattern = new Food(null,500,0);
        int index = Arrays.binarySearch(foods,pattern,(f1,f2)-> f1.getCalories() - f2.getCalories());
        System.out.println(index);
        printArray(foods);
    }




    public void printArray(Object[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("----------------------------");
    }
}