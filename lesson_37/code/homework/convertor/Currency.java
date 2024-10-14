package homework.convertor;
//Задача 3. Создайте enum с кодами валют и их текущими курсами к евро.
// Убедитесь, что в списке нет дублирующихся кодов валют.
// Выведите список валют и их курсов на экран. Реализуйте возможность для
// пользователя выбрать желаемую валюту, ввести ее количество и узнать, сколько он получит при обмене на евро.
public enum Currency {

    USD (1, "USD", 1.00), CHF(2, "CHF", 1.02), GBP (3, "GBP", 1.03), EUR (4, "EUR", 1.04);

    private int number;
    private String name;
    private double course;

    Currency(int number, String name, double course) {
        this.number = number;
        this.name = name;
        this.course = course;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getCourse() {
        return course;
    }
}
