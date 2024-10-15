package classwork.hash_set.model;

import classwork.hash_set.dao.Iset;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements Iset<E> {

    private LinkedList<E>[] hashset;//array of linked lists
    private int size;// amount of e in set
    private int capacity;//amount of yacheek
    private double loadFactor;//loading of zepochek

    //constructor


    public MyHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashset = new LinkedList[capacity];
    }

    public MyHashSet(int capacity) {
        this(capacity,0.75);
    }
    private MyHashSet(){
        this (16);// длина массива hashset
    }

    @Override
    public boolean addElement(E element) {
        if(size >= loadFactor * capacity ) { // не хватило места // O(1)
            rebuildArray(); // увеличиваем
        }
        int index = getIndex(element);
        if (hashset[index] == null) { // если индекс не занять
            hashset[index] = new LinkedList<>(); // создаем новый элемент массива листов
        }
        if (hashset[index].contains(element)) {
            return false; // следим за уникальностью элементов
        }
        hashset[index].add(element); // добавляем элемент
        size++;
        return true;
    }

    private void rebuildArray(){
        capacity = capacity << 1;// увеличили капасити в два раза
        LinkedList<E>[] newHashset = new LinkedList[capacity];
        // надо обежать весь hashSet, залезть в каждый его LinkedList, переложить элементы в новый
        for (int i = 0; i < hashset.length; i++) {
            if (hashset[i] != null) {
                for (E e : hashset[i]) {
                    int index = getIndex(e);
                    if (newHashset[index] == null) {
                        newHashset[index] = new LinkedList<>(); // создаем новый лист
                    }
                    newHashset[index].add(e); // добавляем элемент в LinkedList
                }
            }
        }
        hashset = newHashset; // garbage collector очищает память
    }

    private int getIndex(Object o){
        int hashcode = o.hashCode();//calculation of hashcode
        hashcode = hashcode >= 0 ? hashcode : - hashcode;// // тернарный оператор, делаем положительным
        return hashcode % capacity;//деление с остатком
    }
    @Override
    public boolean contains(Object o) {
        int index = getIndex(0);
        if(hashset[index] == null){
            return false;
        }
       return  hashset[index].contains(0);//проверяем наличие элемента
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);
        if(hashset[index] == null) {
            return false;
        }
        boolean res = hashset[index].remove(o);
        if (res){
            size --;
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int totalCounter ;
            int i;
            int j;

            @Override
            public boolean hasNext() {
                return totalCounter < size;
            }

            @Override
            public E next() {
                while(hashset[i]== null || hashset[i].isEmpty()){
                    i ++;
                }
                E res = hashset[i].get(j);
                totalCounter ++;// сдвинули курсор
                if(j < hashset[i].size()- 1){
                    j ++;
                }
                else {
                    i++;
                    j = 0;
                }
                return null;
            }
        };
    }
}
