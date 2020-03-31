package com.training.martynenka;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

class SortByAmount implements Sorter {
    @Override
    public void sort(int[] array) {
        final Integer[] sorted = ArrayUtils.toObject(array);
        Arrays.sort(sorted, new IntComparator());
        copy(sorted, array);
    }

    private void copy(Integer[] fromArray, int[] toArray) {
        for (int i = 0; i < fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
    }
}
