package com.training.martynenka;

import org.junit.Test;
import org.junit.Assert;

public class MedianTest {

    @Test
    public void testIntFindMedian() {
        double result = Median.findMedian(new int[]{5, 5, 5, 100, 5, 5, 5, 5});
        Assert.assertEquals(5, result, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIntFindMedianEmptyArray() {
        double result = Median.findMedian(new int[0]);
    }

    @Test
    public void testIntFindMedianOddNumber() {
        double result = Median.findMedian(new int[]{1, 5, 2, 8, 7});
        Assert.assertEquals(5, result, 0);
    }

    @Test
    public void testIntFindMedianEvenNumber() {
        double result = Median.findMedian(new int[]{1, 6, 2, 8, 7, 2});
        Assert.assertEquals(4, result, 0);
    }

    @Test
    public void testIntFindMedianEvenAverage() {
        double result = Median.findMedian(new int[]{1, 2, 3, 4});
        Assert.assertEquals(2.5, result, 0);
    }

    @Test
    public void testDoubleFindMedian() {
        double result = Median.findMedian(new double[]{1, 0.5, 0.5, 0.5, 0.5, 0.55, 0.5, 0.5});
        Assert.assertEquals(0.5, result, 0);
    }

    @Test
    public void testDoubleFindMedianOddNumber() {
        double result = Median.findMedian(new double[]{0.5, 0.2, 0.4, 0.3, 0.1});
        Assert.assertEquals(0.3, result, 0);
    }

    @Test
    public void testDoubleFindMedianEvenAverage() {
        double result = Median.findMedian(new double[]{0.1, 0.2, 0.3, 0.4, 0.2, 0.5});
        Assert.assertEquals(0.25, result, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDoubleFindMedianNullArray() {
        int[] arr = null;
        double result = Median.findMedian(arr);
    }
}