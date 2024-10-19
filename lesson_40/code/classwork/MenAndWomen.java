package classwork;

import java.util.HashMap;
import java.util.Map;

//
public class MenAndWomen {
    public static void main(String[] args) {


        // "Leonid" : male
        // "Faran" : female

        Map<String, String> gender = new HashMap<>();

        gender.put("L", "m");
        gender.put("M", "m");
        gender.put("S", "f");
        gender.put("K", "m");
        gender.put("F", "f");
        gender.put("H", "m");
        gender.put("X", "f");
       gender.put("X", "m"); // переписали информацию, обновили

        // 1 option
        int men = 0;
        for(String name: gender.keySet()) {
            if (gender.get(name).equals("m")){
                men ++;
            }
        }
        int women = gender.size() - men;
        System.out.println("m = " + men + " w = " + women);

        //2 option
        women = 0 ;
        for(String g : gender.values())
            if(g.equals("f"))
                women++;
        System.out.println(women);

    }
}
