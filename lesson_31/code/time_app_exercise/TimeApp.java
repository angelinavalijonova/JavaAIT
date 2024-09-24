package time_app_exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeApp {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();// to know todays date
        System.out.println(localDate);//ISO-format

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("---------------------------");

        LocalDate gagarin = LocalDate.of(1961,04,12);
        System.out.println(gagarin);

        // Какой это был день недели?
        System.out.println(gagarin.getDayOfWeek());

        // какой это был день года ?
        System.out.println(gagarin.getDayOfYear());


        System.out.println("-----------LEAP OR NOT----------------");
        //проверка года на високосность
        System.out.println(Year.isLeap(2024));


        System.out.println("---------------------------");
        System.out.println(gagarin.isBefore(localDate));
        System.out.println(gagarin.isAfter(localDate));
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfWeek());

        System.out.println("---------------------------");
        LocalDate event = LocalDate.of(1961,01,01);
        System.out.println(event.compareTo(gagarin));// years

        //travel time

        System.out.println("-----------TRAVEL----------------");
        LocalDate newDate = localDate.plusDays(10);
        System.out.println(newDate);

        newDate = localDate.minusDays(10);
        System.out.println(newDate);

        //chronoUnits
        newDate= localDate.plus(14, ChronoUnit.DECADES);
        System.out.println(newDate);


        localDateTime=localDateTime.plus(14,ChronoUnit.MINUTES);
        System.out.println(localDateTime);

        localDateTime=localDateTime.plus(1,ChronoUnit.HALF_DAYS);
        System.out.println(localDateTime);


        System.out.println("-----------PERIOD----------------");
        long period = ChronoUnit.DAYS.between(gagarin,localDate);
        System.out.println(period);

        period = ChronoUnit.MONTHS.between(gagarin,localDate);
        System.out.println(period);

        LocalDate lenin = LocalDate.of(1870,04,22);
        period = ChronoUnit.DAYS.between(lenin,gagarin);
        System.out.println(period);


        System.out.println("-----------DATETIME FORMATTER----------------");
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
        String date = gagarin.format(df);
        System.out.println(date);

        // другой формат
        df = DateTimeFormatter.ISO_LOCAL_DATE;
        date = gagarin.format(df);
        System.out.println(date);

        //собаственный формат

        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = gagarin.format(df);
        System.out.println(date);

        //собаственный формат
        df = DateTimeFormatter.ofPattern("dd/M/yy");
        date = gagarin.format(df);
        System.out.println(date);

        //собаственный формат
        df = DateTimeFormatter.ofPattern("dd/MMM/yy");
        date = gagarin.format(df);
        System.out.println(date);

        System.out.println("///////////////////////");
        LocalDate day = LocalDate.of(2000,05,04);
        int years = (int)ChronoUnit.YEARS.between(day,localDate);
        System.out.println(years);

        //parsing date from string
        System.out.println("---///////////////////////---");
        String stringDate = "27/08/2024";
        LocalDate res = LocalDate.parse(stringDate,DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        System.out.println(res);

    }
}
