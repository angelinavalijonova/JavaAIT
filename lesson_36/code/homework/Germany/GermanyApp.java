package homework.Germany;

import java.util.LinkedList;
import java.util.List;

//В классе GermanyApp (main) cоздать LinkedList, содержащий города - столицы земель Германии.
// Опробовать на нем методы, которые доступны для класса LinkedList.
// Добавить Гамбург в середину списка, в начало списка.
public class GermanyApp {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Мюнхен"); // Бавария
        list.add("Штутгарт"); // Баден-Вюртемберг
        list.add("Дюссельдорф"); // Северный Рейн-Вестфалия
        list.add("Ганновер"); // Нижняя Саксония
        list.add("Потсдам"); // Бранденбург
        list.add("Киль"); // Шлезвиг-Гольштейн
        list.add("Висбаден"); // Гессен
        list.add("Дрезден"); // Саксония
        list.add("Шверин"); // Мекленбург-Передняя Померания
        list.add("Майнц"); // Рейнланд-Пфальц
        list.add("Эрфурт"); // Тюрингия
        list.add("Магдебург"); // Саксония-Анхальт
        list.add("Саарбрюккен"); // Заарланд
        list.add("Бремен"); // Бремен
        list.add("Берлин"); // Берлин

        System.out.println("---------capitals of states of Germany ----------");
        System.out.println(list);

        // Добавить Гамбург в середину списка
        list.add(8,"Гамбург");
        System.out.println(" ---------------new list with Homburg-------------");
        System.out.println(list);

        // Добавить Гамбург в начало списка
        list.add(2,"Гамбург");
        System.out.println(" ---------------brand new list with Homburg-------------");
        System.out.println(list);

        System.out.println("==================");
        System.out.println(list.size());

        System.out.println("==================");
       list.addFirst("BERLIN");
        System.out.println(list);

        System.out.println("==================");
        list.addLast("BERLIN");
        System.out.println(list);

        System.out.println("==================");
        list.clear();
        System.out.println(list);




    }
}
