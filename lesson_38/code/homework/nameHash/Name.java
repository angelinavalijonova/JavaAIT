package homework.nameHash;

import java.util.*;

//Задача 1. Создайте список из 20 имен людей с повторениями. Удалите из списка все повторяющиеся имена.
// Выведите список уникальных имен в алфавитном порядке.
//Условия: Программа должна использовать HashSet для удаления дубликатов.
//Подсказка: Для сортировки уникальных слов можно использовать класс ArrayList и метод Collections.sort().
// */
public class Name {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Emily");
        names.add("Michael");
        names.add("Sarah");
        names.add("David");
        names.add("Jessica");
        names.add("James");
        names.add("Emma");
        names.add("John");
        names.add("Michael");
        names.add("Emily");
        names.add("David");
        names.add("Jessica");
        names.add("Sarah");
        names.add("Emma");
        names.add("James");
        names.add("Michael");
        names.add("Sarah");
        names.add("Emily");
        names.add("John");

        printArray(names);

        Set<String> uniqueNames = new HashSet<>(names);// для избежания дубликатов

        names.clear();// чистим аррайлист
        names.addAll(uniqueNames);// добавляем уже уникальные имена
        Collections.sort(names);// сортируем
        System.out.println(" ----- sorted unique names : ");
        printArray(names);
    }
    private static <E> void printArray(List<E> list) {
        for (E e : list) {
            System.out.println(e);
        }
    }

}

