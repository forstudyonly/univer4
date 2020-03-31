package com.training.martynenka;

import java.util.Arrays;

public final class Median {
    private static int middle;

    private Median() {
    }

    public static double findMedian(int[] array) {
        if (isEmptyArray(array)) {
            throwNullArrayException();
        }
        int[] copyArray = copyAndSortArray(array);
        if (isEvenCount(copyArray.length)) {
            return calculateMedianEvenArray(copyArray);
        } else {
            return calculateMedianOddArray(copyArray);
        }
    }

    public static double findMedian(double[] array) {
        if (isEmptyArray(array)) {
            throwNullArrayException();
        }
        double[] copyArray = copyAndSortArray(array);
        if (isEvenCount(copyArray.length)) {
            return calculateMedianEvenArray(copyArray);
        } else {
            return calculateMedianOddArray(copyArray);
        }
    }


    private static double calculateMedianOddArray(double[] array) {
        middle = (array.length - 1) / 2;
        return array[middle];
    }

    private static double calculateMedianOddArray(int[] array) {
        middle = (array.length - 1) / 2;
        return array[middle];
    }

    private static double calculateMedianEvenArray(double[] array) {
        middle = array.length / 2 - 1;
        return (array[middle] + array[middle + 1]) / 2;
    }

    private static double calculateMedianEvenArray(int[] array) {
        middle = array.length / 2 - 1;
        return ((double) array[middle] + array[middle + 1]) / 2;
    }


    private static boolean isEvenCount(int arrayLength) {
        return arrayLength % 2 == 0;
    }

    private static int[] copyAndSortArray(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        return copyArray;
    }

    private static double[] copyAndSortArray(double[] array) {
        double[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        return copyArray;
    }

    private static boolean isEmptyArray(int[] array) {
        return array == null || array.length == 0;
    }

    private static boolean isEmptyArray(double[] array) {
        return array == null || array.length == 0;
    }

    private static void throwNullArrayException() {
        throw new IllegalArgumentException("Array can’t be null");
    }
}