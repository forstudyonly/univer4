package com.training.martynenka;

import org.junit.Test;
import org.junit.Assert;

public class BubbleTest {

    @Test
    public void testSort() {
        Bubble bubble = new Bubble();
        int[] array = new int[]{2, 3, 1, 4};
        bubble.sort(array);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, array);
    }

    @Test
    public void testSortNegative() {
        Bubble bubble = new Bubble();
        int[] array = new int[]{2, -3, 1, -4};
        bubble.sort(array);
        Assert.assertArrayEquals(new int[]{-4, -3, 1, 2}, array);
    }

    @Test
    public void testSortZeroArray() {
        Bubble bubble = new Bubble();
        int[] array = new int[0];
        bubble.sort(array);
        Assert.assertArrayEquals(new int[0], array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortNullArray() {
        Bubble bubble = new Bubble();
        int[] array = null;
        bubble.sort(array);
    }
}