package classwork.post_office;
//Post Office Написать приложение, которое позволит понять, из каких мест на данную почту приходят письма.
//
// Оператор будет вводить индексы из приходящих писем, будем их заносить в HashSet
// в конце смены - распечатать HashSet.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PostOfficeApp {
    public static void main(String[] args) {
        Set<String> postcode = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Welcome to Post Office.");

        do{
           System.out.println("Input the post code: ");
            String newPostCode = scanner.nextLine();

            if(postcode.add(newPostCode)) {
                System.out.println("Postcode " + newPostCode +" added ");

            }else {
                System.out.println("Postcode already exists");
            }
            System.out.println("Continue? Press 's' to stop. ");
            char ch  = scanner.next().charAt(0);
            if(ch == 's'){
                flag = false;
            }
            scanner.nextLine();
        }while(flag);

        System.out.println("Post codes :");
        for(String str : postcode){
            System.out.println(str);
        }
    }

}
