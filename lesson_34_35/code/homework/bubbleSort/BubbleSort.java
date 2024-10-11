package homework.bubbleSort;

import java.util.Random;

public class BubbleSort {

    static int[] generateRandomArray(int size) {
        int [] array = new int [size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1001);
        }
        return array;
    }
    static int bubbleSort(int[] arr) {
        int count = 0;   for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }

        return count;
    }

}
