package homework.Country;
// Создайте связный список, содержащий 11 стран из разных континентов.
// Получите списки этих стран, отсортированные по:
//алфавиту;
//по размеру населения в стандартном и обратном порядках;
//принадлежности континенту и размеру населения в порядке от большего к меньшему.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountryApp {
    public static void main(String[] args) {

        List <Country> list = new ArrayList<>();

        list.add(new Country("United Kingdom", 50, "Europe"));
        list.add(new Country("Germany", 80, "Europe"));
        list.add(new Country("Spain", 40, "Europe"));
        list.add(new Country("France", 45, "Europe"));
        list.add(new Country("China", 1600, "Asia"));
        list.add(new Country("Japan", 150, "Asia"));
        list.add(new Country("USA", 250, "North America"));
        list.add(new Country("Canada", 120, "North America"));
        list.add(new Country("Argentina", 80, "South America"));
        list.add(new Country("Brasilia", 100, "South America"));

        System.out.println("=====unsorted=======");
        for(Country c : list)
            System.out.println(c);

        Comparator<Country> alphabetComp = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        System.out.println();
        System.out.println("=====sorted by alphabet=======");
        list.sort(alphabetComp);
        for(Country c : list)
            System.out.println(c);



        Comparator<Country> populationComp = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return Integer.compare(o1.getPopulation(), o2.getPopulation());
            }
        };
        System.out.println();
        System.out.println("=====sorted by population=======");
        list.sort(populationComp);
        for(Country c : list)
            System.out.println(c);

        Comparator<Country> populationComp2 = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return -Integer.compare(o1.getPopulation(), o2.getPopulation());
            }
        };
        System.out.println();
        System.out.println("=====sorted by population vice versa=======");
        list.sort(populationComp2);
        for(Country c : list)
            System.out.println(c);


        Comparator<Country> comparatorByContinentAndPopulation = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                int res = o1.getContinent().compareTo(o2.getContinent());
                return res !=0 ? res : -(o1.getPopulation() - o2.getPopulation());
            }
        };
        System.out.println();
        System.out.println("----------- Sorted by Continent and Population ---------");
        list.sort(comparatorByContinentAndPopulation);
        for (Country c : list) {
            System.out.println(c);
        }


    }
}
