package homework.alphabet;
//Заполните структуру типа ArrayList<> символами латинского алфавита от A(65) до Z(...).

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static void main(String[] args) {
        List<Character> alphList = new ArrayList<>();

       for (char c = 'A'; c <= 'Z'; c++) {
           alphList.add(c);
       }
        System.out.println(alphList);
        }
    }


