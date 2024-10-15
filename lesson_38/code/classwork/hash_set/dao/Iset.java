package classwork.hash_set.dao;


public interface Iset<E> extends Iterable<E> {

    boolean addElement(E element);

    boolean contains (Object o);

    boolean remove(Object o);

    int size();

}