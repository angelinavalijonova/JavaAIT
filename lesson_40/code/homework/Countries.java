package homework;

//Соберите в структуру Map порядка 20 стран, по несколько страны из разных континентов Земли.
//Подсчитайте количество стран на континентах из полученного списка.

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Countries {
    public static void main(String[] args) {
        Map<String,String> countriesMap = new HashMap<>();
        countriesMap.put("Germany", "Europe");
        countriesMap.put("France", "Europe");
        countriesMap.put("Spain", "Europe");
        countriesMap.put("Italy", "Europe");
        countriesMap.put("UK", "Europe");
        countriesMap.put("China", "Asia");
        countriesMap.put("Japan", "Asia");
        countriesMap.put("India", "Asia");
        countriesMap.put("Iran", "Asia");
        countriesMap.put("South Korea", "Asia");
        countriesMap.put("Thailand", "Asia");
        countriesMap.put("Egypt", "Africa");
        countriesMap.put("Ghana", "Africa");
        countriesMap.put("South Africa", "Africa");
        countriesMap.put("Kenia", "Africa");
        countriesMap.put("USA", "North America");
        countriesMap.put("Canada", "North America");
        countriesMap.put("Mexico", "North America");
        countriesMap.put("Chili", "South America");
        countriesMap.put("Brasilia", "South America");
        countriesMap.put("Argentina", "South America");


        System.out.println(countriesMap.size());

        //print keys
        for(String k : countriesMap.keySet())
            System.out.println("Country:" + k);

        System.out.println("=================");
        //print values
        //let's try to sort
        Collection<String> continent = countriesMap.values();
        for(String v: continent)
            System.out.println("Continent: " + v );

        System.out.println("=================");
        //print keys and values
        for(String k : countriesMap.keySet())
            System.out.println("Country: " + k + " Continent: " + countriesMap.get(k));

        Map<String, Integer> countriesOnContinent = new HashMap<>();//хотим узнать сколько стран на континенте

        for (String continen : countriesMap.values()) { // проходим по всем значениям
//            countriesOnContinent.putIfAbsent(continent, 1);

            if(!countriesOnContinent.containsKey(continen)){ // такое слово еще не встречалось
                countriesOnContinent.put(continen, 1); // пишем в мапу континент и 1
            } else {
                countriesOnContinent.put(continen, countriesOnContinent.get(continen) + 1);
            }

        }
        // распечатаем содержимое полученной map
        System.out.println("======= Print Map Continent -> Number of Countries========");
        Set<String> keySet = countriesOnContinent.keySet();
        for (String key : keySet) {
            System.out.println(key + " -> " + countriesOnContinent.get(key));
        }


    }

}
