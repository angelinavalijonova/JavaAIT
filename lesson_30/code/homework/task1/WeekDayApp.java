package homework.task1;
//Опробовать на нем методы: .VALUES() .toString .ordinal() .valueOf()
//Реализуйте метод, позволяющий прибавлять дни к выбранному дню недели, получая правильный день недели.
// Пример: Monday + 10 days = Thursday (понедельник + 10 дней = четверг) Проверьте работу метода с помощью теста.
public class WeekDayApp {
    public static void main(String[] args) {
        WeekDay [] weekDays = WeekDay.values();//// values of enum is now in array

        System.out.println("-------- values----------");
        for (int i = 0; i < weekDays.length; i++) {
            System.out.println(weekDays[i].getDay() + " is " + weekDays[i].getNumber() + " day of the week" );
        }
        System.out.println("-------- toString----------");
        String str = WeekDay.MONDAY.toString();
        System.out.println(str);

        System.out.println("--------ordinal---------");
        int n = WeekDay.SUNDAY.ordinal();
        System.out.println(n);

        System.out.println("--------ordinal---------");
        int m = WeekDay.SUNDAY.getNumber();
        System.out.println(m);

        System.out.println("--------valueOf---------");
        WeekDay day = WeekDay.valueOf("WEDNESDAY");
        System.out.println(day);




    }
}
