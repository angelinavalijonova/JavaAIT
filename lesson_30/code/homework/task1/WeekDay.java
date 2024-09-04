package homework.task1;
//Задача 1. Задать ENUM weekDay - дни недели. Опробовать на нем методы: .VALUES() .toString .ordinal() .valueOf()
//Реализуйте метод, позволяющий прибавлять дни к выбранному дню недели, получая правильный день недели.
// Пример: Monday + 10 days = Thursday (понедельник + 10 дней = четверг) Проверьте работу метода с помощью теста.
public enum WeekDay {
    MONDAY("Monday",1),TUESDAY("Tuesday",2),WEDNESDAY("Wednesday",3),
    THURSDAY("Thursday",4),FRIDAY("Friday",5),SATURDAY("Saturday",6),
    SUNDAY("Sunday",7);

    private String day;
    private int number;

    WeekDay(String day, int number) {
        this.day = day;
        this.number = number;
    }

    public String getDay() {
        return day;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeekDay{");
        sb.append("day='").append(day).append('\'');
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }

    public WeekDay plusDays(WeekDay day, int quantity){
        int index = day.ordinal();
        index += quantity;
        WeekDay [] weekDays = WeekDay.values();// values of enum is now in array
        int res = index % weekDays.length;
        return weekDays[res];
    }
}
