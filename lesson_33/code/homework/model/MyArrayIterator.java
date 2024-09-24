package homework.model;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {

    private ArrayList<Integer> array ;
    private int index;

    public MyArrayIterator(ArrayList<Integer> array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.size();
    }

    @Override
    public Integer next() {
        Integer current = array.get(index);
        index++;
        return current;
    }

    @Override
    public void remove() {
        array.remove(index - 1);
        index--;
    }
}
