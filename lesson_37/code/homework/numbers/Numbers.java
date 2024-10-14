package homework.numbers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//
//  Написать программу, которая:
//        - прочитает с клавиатуры количество вводимых чисел,
//        - прочитает с клавиатуры сами числа и соберёт их в множество,
//        - удалить из множества числа, большие 10,
//        выведет полученные результаты на экран
//        Все числа, которые подаются на вход, целые.

public class Numbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many numbers you want to input?" );
        int n = scn.nextInt();
        scn.nextLine();


        Set<Integer> numbers = new HashSet<>();
        System.out.println("Size of set = " + numbers.size());

        while (numbers.size() < n) {
            System.out.println("Write the number you want to input: ");
            int nmb = scn.nextInt();
            if(numbers.add(nmb)) {
                System.out.println("Inputet number");
            } else {
                System.out.println("Number already exists it set.");
            }
            System.out.println("Your list contains :");
            System.out.println(numbers);
        }

        System.out.println("Remove numbers > 10");
        for (Integer num : numbers) {
            if(num > 10){
                numbers.remove(num);
            }
        }
        System.out.println("Set consist numbers:");
        System.out.println(numbers);

    }
    }

