package classwork.complexity;

import java.util.Arrays;

public class ComplexityApp {
    public static void main(String[] args) {
        // заведем массив целых чисел
        // будем выполнять с ним различные операции (вычисление среднего, сложение элементов, поиск элемента, поиск мин и макс, сортировка)
        // оценим вычислительную сложность алгоритма

        int [] arr = {-24, 7, -67, 15, 8, 93, 1};

        //вычисление среднего значения

        int sum = 0;//O(1) - complexity, константная
        for (int i = 0; i < arr.length; i++) {//O(n)

            sum += arr[i];//O(1)
        }
        double avg = (double)sum / arr.length;
        //общая сложность O(1) + O(n) + O(1) = O(n)

        System.out.println("-------------");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------");

        int index = Arrays.binarySearch(arr, -67);
        System.out.println(index); // 0

        index = Arrays.binarySearch(arr, 93);
        System.out.println(index); // 6

        index = Arrays.binarySearch(arr, -100);
        System.out.println(index); // -1

        // при 8 элементах - 3 итерации
        // при 16 элементах - 4 итерации
        // при 1024 элементах - 10 итераций

        // O(log(n)) - это логарифмическая сложность (следующая за константной)

        // сортировка методом BubbleSort сравниваем по 2 элемента, i - й с i + 1 -ым

        int count = 0;
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    // переставим элементы местами
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
        // это квадратичная сложность O(n^2))

    }
}