package classwork.i_list.model;

import classwork.copyPractice.SystemArrayCopy;

import java.util.Arrays;
import java.util.Iterator;

public class IListImpl<E> implements IList<E> {
    Object [] elements;
    private int size;//размер листа

    // constructor
    public IListImpl(int initialCapacity){

        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal capacity" + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    public IListImpl(){//начальный размер списка
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clean() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();// проверка возможности вставки
        elements[size ++] = element;//добавляем в конец списка O(1)
        return true;
    }
    private void ensureCapacity() {
        if (size == elements.length) { // O(1)
            if (size == Integer.MAX_VALUE) {// O(1)
                throw new OutOfMemoryError(); // большего по размеру списка создать не можем// O(1)
            }
            int newCapacity = elements.length + elements.length / 2;// O(1)
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newCapacity);// O(n)
        }
    }

    @Override
    public boolean add(int index, E element) {
        if (index == size){// добавляем в конец списка
            add(element);
            return true;
        }
        //добавляем в середину списка
        checkIndex(index);
        ensureCapacity();//проверка возможности вставки
        System.arraycopy(elements,index,elements,index + 1,size++ - index);//развинули массив на одну позицию
        elements[index] = element;
        return true;
    }
    private  void checkIndex(int index){
        //индекс не может быть отрицательным и быть больше чем сайз
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Wrong Index" + index);
        }
    }


    @Override
    public E remove(int index) {
        checkIndex(index);
        // ищем элемент
        E el = (E) elements[index];
        // удаляем элемент
        System.arraycopy(elements,index + 1 ,elements,index,--size - index);
        elements[size] = null;//устанавливает последний элемент массива в null, освобождая его место
        return el;
    }
    //    После выполнения System.arraycopy, когда элементы сдвигаются на одну позицию назад,
//    последний элемент становится дублированным на предпоследней позиции.
//    Затирание последнего элемента elements[size] = null; выполняется для очистки этой дублированной позиции,
//    иначе в списке может остаться ссылка на ненужный объект, что может вызвать утечку памяти.
//    Этот шаг необходим для правильной работы списка и предотвращения утечек памяти. В Java объекты не удаляются
//    сразу после вызова remove, и сборка мусора может произойти позже. Поэтому затирание последнего элемента является
//    хорошей практикой для избежания утечек памяти.

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E victim = (E) elements[index];
        elements[index]=element;
        return victim;
    }

    @Override
    public int indexOf(Object o) {
        if(o != null) {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if(elements[i]==null){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {

                return (E) elements[i++];
            }
        };
    }
}
