package homework.model;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArray implements Iterable<Integer> {

    ArrayList<Integer> myArray ;

    public MyArray(ArrayList<Integer> myArray) {
        this.myArray = myArray;
    }

    public void setMyArray(ArrayList<Integer> myArray) {
        this.myArray = myArray;
    }


    @Override
    public String toString() {
        return myArray.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(myArray);
    }
}
