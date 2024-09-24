package homework.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayApp {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(-1,2,-3,4,-5,6,-7,8));
        MyArray myArray = new MyArray(array);
        System.out.println(myArray);

        //изменить знак каждого элемента на противоположный;

        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("numbers with changed values:");
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.print( i * -1 + ", ");
        }

        System.out.println();

        //возвести каждый элемент множества в квадрат;
        iterator = myArray.iterator();
        System.out.println("squared numbers :");
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.print(i * i + ", ");
        }
        System.out.println();

       // удалить все четные элементы.
        iterator = myArray.iterator();
        System.out.println("delete all even numbers");
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i % 2 == 0 ){
                iterator.remove();
            }

        }
        for (Integer i : myArray){
            System.out.print(i + ", ");
        }
    }
}
