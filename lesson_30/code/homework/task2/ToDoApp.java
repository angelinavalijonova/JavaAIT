package homework.task2;

import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoImpl myTodoList = new ToDoImpl();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag) {
            MenuAction.printMenu();

            System.out.print("Choose action: ");
            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1 -> myTodoList.addTask();
                case 2 -> myTodoList.taskOverview();
                case 3 -> myTodoList.deleteTask();
                case 4 -> flag = false;
                default -> System.out.println("Wrong choice");
            }
        }
    }
}
