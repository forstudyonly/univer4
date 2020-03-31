package com.training.martynenka;

import java.util.*;

public class MyList<T> implements List<T> {
    private static final int STANDARD_CAPACITY = 10;
    private final int MAX_CAPACITY;
    private Object[] Data;

    public MyList() {
        this(STANDARD_CAPACITY);
    }

    public MyList(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("Cannot create a negative sheet size");
        }
        MAX_CAPACITY = maxCapacity;
        Data = new Object[0];
    }

    public MyList(T[] array) {
        this(array, array.length);
    }

    public MyList(T[] array, int maxCapacity) {
        this(maxCapacity);
        copyArrayToData(array, maxCapacity > array.length ? array.length : maxCapacity);
    }

    @Override
    public int size() {
        return Data.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == MAX_CAPACITY;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (Data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return copyOfData();
    }

    @Override
    public boolean add(T o) {
        if (checkOverflow(size() + 1)) {
            ResizeData(size() + 1);
            Data[size() - 1] = o;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < Data.length; index++) {
            if (o.equals(Data[index])) {
                removeInData(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (int i = 0; i < size(); i++) {
            if (c.contains(Data[i])) {
                remove(Data[i]);
                i--;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        Data = new Object[0];
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] arrayCollection = c.toArray();
        if (checkOverflow(size() + arrayCollection.length)) {
            return false;
        }
        for (int i = 0; i < arrayCollection.length; i++) {
            add((T) arrayCollection[i]);
        }
        return true;
    }

    @Override
    public T get(int index) {
        checkRange(index);
        return (T) Data[index];
    }

    private void checkRange(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Out of range index");
        }
    }

    private boolean checkOverflow(int size) {
        try {
            if (size > MAX_CAPACITY) {
                throw new AddToFullListException("List overflow");
            }
            return true;
        } catch (AddToFullListException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void ResizeData(int size) {
        Object[] newData = new Object[size];
        for (int i = 0; i < size(); i++) {
            newData[i] = Data[i];
        }
        Data = newData;
    }

    private void removeInData(int index) {
        Object[] newData = new Object[size() - 1];
        boolean isPassed = false;
        for (int i = 0; i < size(); i++) {
            if (i != index && !isPassed) {
                newData[i] = Data[i];
            } else if (i != index && isPassed) {
                newData[i - 1] = Data[i];
            } else if (i == index) {
                isPassed = true;
            }
        }
        Data = newData;
    }

    private void copyArrayToData(T[] array, int fillingOut) {
        Data = new Object[fillingOut];
        for (int i = 0; i < fillingOut; i++) {
            Data[i] = array[i];
        }
    }

    private Object[] copyOfData() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = Data[i];
        }
        return array;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

}
