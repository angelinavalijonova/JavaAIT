package homework.convertor;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//// Убедитесь, что в списке нет дублирующихся кодов валют. DONE
//// Выведите список валют и их курсов на экран. Реализуйте возможность для
//// пользователя выбрать желаемую валюту, ввести ее количество и узнать, сколько он получит при обмене на евро.
public class CurrencyConvertor {

    public static void main(String[] args) {

        Currency[] currency = Currency.values();
        for (Currency c: currency) {
            System.out.println(c);
        }

        Set<String> currNames = new HashSet<>();
////// Выведите список валют и их курсов на экран. Реализуйте возможность для пользователя выбрать желаемую валюту
        for (int i = 0; i < currency.length; i++) {
            if(currNames.add(currency[i].getName())) {
                System.out.println(currency[i].getName() + " added.");
            } else {
                System.out.println(currency[i].getName() + " already exists.");
            }
        }

        System.out.println("Menu : ");
        int count = 0;
        for (String s: currNames) {
            count++;
            System.out.println(count + " : " +s);
        }
//Реализуйте возможность для пользователя выбрать желаемую валюту
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of currency: ");
        int currNumber = scanner.nextInt();
        System.out.println("Input amount of money: ");
        int sum = scanner.nextInt();

        double course = currency[currNumber - 1].getCourse();

        double res = sum * course;

        System.out.printf("You got: %.2f", res);
        System.out.println(" euro.");

    }

}
