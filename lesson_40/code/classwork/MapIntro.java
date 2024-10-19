package classwork;

import java.util.*;

// Создадим Map, которая содержит наименование горда и его население
// key - это город, тип String
// value - это население, тип Integer
public class MapIntro {
    public static void main(String[] args) {

        Map<String,Integer> cities = new TreeMap<>();

        cities.put("Denver", 600_000);
        cities.put("Boston", 670_000);
        cities.put("Chicago", 2_700_000);
        cities.put("Atlanta", 470_000);
        cities.put("New York", 8_500_000);
        cities.put("Dallas", 1_300_000);

        System.out.println(cities.size());// 6
        System.out.println(cities.isEmpty());// f

        System.out.println("--------------");
        int population = cities.get("Chicago");
        System.out.println(population);

        System.out.println("--------------");
        System.out.println(cities.containsKey("Boston"));//t
        System.out.println(cities.containsKey("Odessa"));//f
        System.out.println("--------------");

        //total population
        //1st option -
        Collection<Integer> totalPopulation = cities.values();// created new object
        int total = 0;
        for (Integer i : totalPopulation){
            total += i;
        }
        System.out.println("Total population " + total);

        //print
        for(Integer i : totalPopulation)
            System.out.println(i);

        System.out.println("--------------");
        // print keys
        for(String key : cities.keySet())
            System.out.println(key);
        System.out.println("--------------");

        // print values
        for (Integer value : cities.values())
            System.out.println(value);
        System.out.println("--------------");

        // print keys and values
        for (String key : cities.keySet())
            System.out.println("key: " + key + " values: " + cities.get(key));

        // 2 Option
        System.out.println("===========================");
        Set<String> setOfCities = cities.keySet();
        total = 0;
        for(String str: setOfCities)
            total += cities.get(str);
        System.out.println(total);



    }
}
