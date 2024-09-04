package homework.task2;

import java.util.Arrays;
import java.util.Scanner;

public class ToDoImpl implements ToDo{

    private String[] tasks = new String[2];
    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean addTask() {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        for (int i = 0; i < tasks.length; i++) {
            if(tasks[i] == null){
                tasks[i] = taskName;
                System.out.println("Action " + taskName + " successfully added.");
                return true;
            }
        }
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = taskName;
        System.out.println("Action " + taskName + " successfully added.");
        return true;
    }


    @Override
    public void taskOverview() {
        System.out.println("Your list for today: ");
        for(int i = 0; i < tasks.length; i++) {
            if(tasks[i] != null)
                System.out.println((i + 1) + ": " + tasks[i]);
        }
    }

    @Override
    public boolean deleteTask() {
        System.out.print("Enter task number to delete: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        taskNumber -= 1;  // to turn input into index
        String taskToDelete = tasks[taskNumber];

        String[] newTasks = new String[tasks.length - 1];
        System.arraycopy(tasks, 0, newTasks, 0, taskNumber);
        System.arraycopy(tasks, taskNumber + 1, newTasks, taskNumber, tasks.length - 1 - taskNumber);
        tasks = newTasks;
        System.out.println("Task " + taskToDelete + " deleted successfully.");
        return true;
    }
}
