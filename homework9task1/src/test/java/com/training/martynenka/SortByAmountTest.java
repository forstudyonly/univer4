package com.training.martynenka;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SortByAmountTest {
    private int[] mass1;
    private final int[] MASS_1_SORT = new int[]{1, 2, 3};
    private int[] mass2;
    private final int[] MASS_2_SORT = new int[]{1, -2, 3};
    private int[] mass3;
    private final int[] MASS_3_SORT = new int[]{0, 1000, 20, -30, 17, -99};

    private Sorter sorter;

    @Before
    public void init() {
        mass1 = new int[]{2, 1, 3};
        mass2 = new int[]{-2, 1, 3};
        mass3 = new int[]{20, -99, 17, 0, -30, 1000};
        sorter = new SortByAmount();
    }

    @Test
    public void sortTest1() {
        sorter.sort(mass1);
        Assert.assertArrayEquals(MASS_1_SORT, mass1);
    }

    @Test
    public void sortTest2() {
        sorter.sort(mass2);
        Assert.assertArrayEquals(MASS_2_SORT, mass2);
    }

    @Test
    public void sortTest3() {
        sorter.sort(mass3);
        Assert.assertArrayEquals(MASS_3_SORT, mass3);
    }
}