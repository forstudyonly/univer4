package com.training.martynenka;

import org.junit.Test;
import org.junit.Assert;

public class SortingContextTest {

    private final int[] ARRAY = new int[]{1, 2, 4, 3, 6, 5, 9, 8, 7};
    private final int[] SORT_ARRAY = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void testExecuteBubble() {
        Bubble bubble = new Bubble();
        SortingContext sortContext = new SortingContext(bubble);
        sortContext.execute(ARRAY);
        Assert.assertArrayEquals(SORT_ARRAY, ARRAY);
    }

    @Test
    public void testExecuteSelection() {
        Selection selection = new Selection();
        SortingContext sortContext = new SortingContext(selection);
        sortContext.execute(ARRAY);
        Assert.assertArrayEquals(SORT_ARRAY, ARRAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullBubble() {
        Bubble bubble = null;
        SortingContext sortContext = new SortingContext(bubble);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSelection() {
        Selection selection = null;
        SortingContext sortContext = new SortingContext(selection);
    }
}