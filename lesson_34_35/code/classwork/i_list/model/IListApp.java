package classwork.i_list.model;

public class IListApp {
    public static void main(String[] args) {
        IList<Integer> listOfAges  = new IListImpl<>();
        for (int i = 0; i < 150; i++) {
            listOfAges.add(i * 10);
        }
        for (Integer i : listOfAges) {
            System.out.print(i + " | ");
        }
        System.out.println();

        System.out.println(listOfAges.size());
        System.out.println(listOfAges.isEmpty());
        System.out.println(listOfAges.indexOf(34));
        System.out.println(listOfAges.remove(5));


        // now with String

        IList<String> listOfNames = new IListImpl<>();

        listOfNames.add("Oleg");
        listOfNames.add("Juri");
        listOfNames.add("Denis");
        listOfNames.add("Sergej");
        listOfNames.add("Farangiz");
        listOfNames.add("Konstantin");

        for (String str : listOfNames) {
            System.out.println(str);
        }
        // под каким номером (индексом) в списке Sergej
        int i = listOfNames.indexOf("Sergej");
        System.out.println(i);
        // ищем того, кого нет в списке
        i = listOfNames.indexOf("Leonid"); // -1
        System.out.println(i);

    }
}
