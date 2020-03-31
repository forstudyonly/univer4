package com.training.martynenka;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class MyListTest {
    private MyList<String> myListStandard;
    private MyList<String> myListCapacity3;
    private MyList<String> myListArray;
    private MyList<String> myListArrayPlusCapacity;
    private final String[] STANDARD_ARRAY = new String[]{"1", "2", "3"};
    private final String STRING = "string";
    private final int MINUS_FIVE = -5;
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int EIGHT = 8;

    @Before
    public void init() {
        myListArrayPlusCapacity = new MyList<String>(STANDARD_ARRAY, FIVE);
        myListArray = new MyList<String>(STANDARD_ARRAY);
        myListCapacity3 = new MyList<String>(THREE);
        myListStandard = new MyList<String>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionNegativeNumberOfItems() {
        MyList<String> myList = new MyList<String>(MINUS_FIVE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionNegativeNumberOfItemsWithArray() {
        MyList<String> myList = new MyList<String>(STANDARD_ARRAY, MINUS_FIVE);
    }

    @Test
    public void checkSpecificList() {
        MyList<String> specificList = new MyList<String>(STANDARD_ARRAY, EIGHT);
        Assert.assertEquals(THREE, specificList.size());
        specificList = new MyList<String>(STANDARD_ARRAY, ONE);
        Assert.assertEquals(ONE, specificList.size());
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(ZERO, myListStandard.size());
        Assert.assertEquals(ZERO, myListCapacity3.size());
        Assert.assertEquals(THREE, myListArray.size());
        Assert.assertEquals(THREE, myListArrayPlusCapacity.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(true, myListStandard.isEmpty());
        Assert.assertEquals(true, myListCapacity3.isEmpty());
        Assert.assertEquals(false, myListArray.isEmpty());
        Assert.assertEquals(false, myListArrayPlusCapacity.isEmpty());
    }

    @Test
    public void containsTest() {
        Assert.assertEquals(true, myListArray.contains("1"));
        Assert.assertEquals(false, myListArray.contains("4"));
    }

    @Test
    public void toArrayTest() {
        Object[] array = myListArrayPlusCapacity.toArray();
        Assert.assertEquals(THREE, array.length);
    }

    @Test
    public void isFullTest() {
        Assert.assertEquals(false, myListStandard.isFull());
        Assert.assertEquals(false, myListCapacity3.isFull());
        Assert.assertEquals(true, myListArray.isFull());
        Assert.assertEquals(false, myListArrayPlusCapacity.isFull());
    }

    @Test
    public void addTest() {
        myListArrayPlusCapacity.add(STRING);
        Assert.assertEquals(FOUR, myListArrayPlusCapacity.size());
        myListArrayPlusCapacity.add(STRING);
        Assert.assertEquals(FIVE, myListArrayPlusCapacity.size());
        Assert.assertEquals(true, myListArrayPlusCapacity.isFull());
        myListArrayPlusCapacity.add(STRING);
    }

    @Test
    public void removeTest() {
        Assert.assertEquals(THREE, myListArrayPlusCapacity.size());
        myListArrayPlusCapacity.remove("1");
        Assert.assertEquals(TWO, myListArrayPlusCapacity.size());
        myListArrayPlusCapacity.remove("1");
        Assert.assertEquals(TWO, myListArrayPlusCapacity.size());
        myListArrayPlusCapacity.remove("2");
        Assert.assertEquals(ONE, myListArrayPlusCapacity.size());
    }

    @Test
    public void removeAllTest() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("2");
        arrayList.add("3");
        myListArrayPlusCapacity.removeAll(arrayList);
        Assert.assertEquals(ONE, myListArrayPlusCapacity.size());
        myListArrayPlusCapacity.add("2");
        Assert.assertEquals(TWO, myListArrayPlusCapacity.size());
        arrayList.add("1");
        myListArrayPlusCapacity.removeAll(arrayList);
        Assert.assertEquals(ZERO, myListArrayPlusCapacity.size());
    }

    @Test
    public void clearTest() {
        myListArrayPlusCapacity.clear();
        Assert.assertEquals(true, myListArrayPlusCapacity.isEmpty());
    }

    @Test
    public void getTest() {
        String string = myListArrayPlusCapacity.get(ONE);
        Assert.assertEquals(string, "2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutTest() {
        String string = myListArrayPlusCapacity.get(EIGHT);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutTest1() {
        String string = myListArrayPlusCapacity.get(MINUS_FIVE);
    }
}