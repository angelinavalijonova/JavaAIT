package classwork.cityBus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CityBusApp {

    public static void main(String[] args) {

        List<Bus> cityBusList = new ArrayList<>();

        cityBusList.add(new Bus("Man", "num1", "3", 35));
        cityBusList.add(new Bus("Scania", "num2", "10A", 40));
        cityBusList.add(new Bus("MAN", "num3", "10C", 25));
        cityBusList.add(new Bus("Mercedes", "num4", "1A", 35));
        cityBusList.add(new Bus("Volvo", "num5", "100", 45));


        System.out.println(cityBusList.size());

        // print
        for (Bus b : cityBusList) {
            System.out.println(b);
        }
        System.out.println("==============");
        cityBusList.sort(Bus::compareTo);//sorting
        for (Bus b : cityBusList) {
            System.out.println(b);
        }

        // реализуем внутренний класс
        Comparator<Bus> comparator = new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                int res = - Integer.compare(o1.getBusCapacity(), o2.getBusCapacity());
                return res != 0 ? res : o1.getRouteNumber().compareTo(o2.getRouteNumber());
            }
        };
        cityBusList.sort(comparator);
        System.out.println("==============");

        for (Bus b : cityBusList) {
            System.out.println(b);
        }
    }
}
