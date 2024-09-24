package classwork.myString_iterator;

import classwork.myString_iterator.model.MyString;

import java.util.Iterator;

public class MyStringApp{
    public static void main(String[] args) {
        MyString myString = new MyString("Two beer, or not two beer");
        System.out.println(myString);
        myString.addChar('!');
        System.out.println(myString);
        myString.removeChar(',');
        System.out.println(myString);

        System.out.println("==============");
//        StringBuilder sb = myString.getStr();
//        System.out.println(sb);
//        sb.setLength(5);
//        System.out.println(sb);
//        System.out.println(myString);

        Iterator<Character> iterator = myString.iterator();
        while (iterator.hasNext()){
            char c = iterator.next();// cursor is at the end
            System.out.print(Character.toUpperCase(c));
        }
        System.out.println();

        System.out.println("==============");
        for (Character c : myString){
            System.out.print(c);
        }
        System.out.println();

        System.out.println("---------------");

        iterator= myString.iterator();//cursor is now back to begin, so we can use it again
        while (iterator.hasNext()){
            char c = iterator.next();
            if(c == 'o'){
                iterator.remove();
            }
        }
        System.out.println(myString);



    }
}
