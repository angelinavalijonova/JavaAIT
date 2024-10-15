package homework.mathInfoStudents;

import java.util.HashSet;
import java.util.Set;

//Напишите программу, которая: Создает список студентов, зарегистрированных на два разных курса: "Математика" и "Информатика".
// Выводит: Список студентов, которые записаны на оба курса.
// Список студентов, которые записаны только на один из курсов.
// Условия: Используйте два HashSet для хранения студентов каждого курса.
// Программа должна использовать операции пересечения и разности множеств для вывода нужных списков.
public class MathInfo {
    public static void main(String[] args) {
        Set<Integer> mathStudents = new HashSet<>();//
        Set<Integer> infoStudents = new HashSet<>();

        mathStudents.add(123);//by student ID
        mathStudents.add(345);
        mathStudents.add(567);
        mathStudents.add(789);

        infoStudents.add(123);
        infoStudents.add(345);
        infoStudents.add(987);
        infoStudents.add(765);

        Set<Integer> bothCourses = new HashSet<>(mathStudents);
        bothCourses.retainAll(infoStudents);
        System.out.println("ID студентов, которые записаны на оба курса : " + bothCourses);

        Set<Integer> onlyOneCourse = new HashSet<>(mathStudents);
        onlyOneCourse.addAll(infoStudents);
        System.out.println("ID студентов, которые записаны только на один из курсов : " + onlyOneCourse);

    }

}
