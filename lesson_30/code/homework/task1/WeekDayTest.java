package homework.task1;

public class WeekDayTest {

    public static void main(String[] args) {

        WeekDay w = WeekDay.FRIDAY;
        System.out.println(w);
        System.out.println(w.plusDays(w,2));
        System.out.println(w.plusDays(w,7));
    }
}
