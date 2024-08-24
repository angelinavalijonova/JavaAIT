package homework.task2;
//Напишите OddEvenComparator, реализующий Comparator
// с методом сравнения для сортировки массива целых чисел в следующем порядке:
// четные целые числа должны идти перед нечетными числами.
// Для проверки работы компаратора создайте обычный класс,
// в нем метод main, задайте в нем массив из 10 случайных чисел
// в интервале от 1 до 100 и отсортируйте его с помощью OddEvenComparator.
//Пример: int[] array = {2, 5, 6, 10, 11, 18, 3}
//Результат после сортировки: {2, 6, 10, 18, 5, 11, 3}

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class OddEvenComparator {

    @Test
    void testOddEvenComparator() {


        Comparator<Integer> oddEvenComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 0 && o2 % 2 == 0) {
                    return -1;
                } else if (o1 % 2 != 0 && o2 % 2 != 0) {
                    return 1;
                } else
                    return 0;
            }
        };

        Integer[] array = {5, 3, -8, 5, 8, 3, -12, 7, 4, 2, -1, 0, 3, 4, 8, 9};
        System.out.println("============ array as is ==============");
        System.out.println(Arrays.toString(array));

        System.out.println("============ array after sorting ==========");
        Arrays.sort(array, oddEvenComparator);
        System.out.println(Arrays.toString(array));
    }
}