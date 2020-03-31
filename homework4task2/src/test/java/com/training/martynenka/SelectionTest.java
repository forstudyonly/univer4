package com.training.martynenka;

import org.junit.Test;
import org.junit.Assert;

public class SelectionTest {

    @Test
    public void testSort() {
        Selection selection = new Selection();
        int[] array = new int[]{2, 3, 1, 4};
        selection.sort(array);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, array);
    }

    @Test
    public void testSortNegative() {
        Selection selection = new Selection();
        int[] array = new int[]{2, -3, 1, -4};
        selection.sort(array);
        Assert.assertArrayEquals(new int[]{-4, -3, 1, 2}, array);
    }

    @Test
    public void testSortZeroArray() {
        Selection selection = new Selection();
        int[] array = new int[0];
        selection.sort(array);
        Assert.assertArrayEquals(new int[0], array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortNullArray() {
        Selection selection = new Selection();
        int[] array = null;
        selection.sort(array);
    }
}