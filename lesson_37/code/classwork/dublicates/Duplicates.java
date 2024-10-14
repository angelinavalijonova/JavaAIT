package classwork.dublicates;


import java.util.*;

public class Duplicates {

    private static final int N_NUMBERS = 100;
    private static final Random random = new Random();
    private static final int MIN = 1;
    private static final int MAX = 20;

    public static void main(String[] args) {

        // we are creating array list of random numbers
        List<Integer> list = new ArrayList<>();
        fillCollection(list);
        printList(list);

        // array list to hashSet
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer i : list){
            uniqueNumbers.add(i);
        }
        System.out.println(uniqueNumbers);
        System.out.println(uniqueNumbers.size());
    }
    private static void fillCollection(List<Integer> list){
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(random.nextInt(MIN, MAX));
        }
    }

    private static void printList(List<Integer> list){
        for (Integer i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("======================================");
    }


}
