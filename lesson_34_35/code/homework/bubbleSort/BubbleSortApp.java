package homework.bubbleSort;
//Задача 1. Дополните метод bubbleSort счетчиком, который позволяет узнать, сколько операций было выполнено по ходу сортировки.
// Выполните сортировку элементов массивов, в которых содержатся 10, 100 и 1000 элементов.
// Массивы заполните случайными целыми числами в интервале от 0 до 1000. Как растет количество операций
// при сортировке при росте количества элементов массива?

import java.util.Random;

import static homework.bubbleSort.BubbleSort.bubbleSort;
import static homework.bubbleSort.BubbleSort.generateRandomArray;

public class BubbleSortApp {

    public static void main(String[] args) {

        int[] array10 = generateRandomArray(10);
        int[] array100 = generateRandomArray(100);
        int[] array1000 = generateRandomArray(1000);

        int operations10 = bubbleSort(array10.clone());
        int operations100 = bubbleSort(array100.clone());
        int operations1000 = bubbleSort(array1000.clone());

        System.out.println("Количество операций для массива из 10 элементов: " + operations10);
        System.out.println("Количество операций для массива из 100 элементов: " + operations100);
        System.out.println("Количество операций для массива из 1000 элементов: " + operations1000);

    }

}
