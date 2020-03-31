package com.training.martynenka;

public class Selection implements Sorter {
    @Override
    public void sort(int[] array) {
        isNullArray(array);
        for (int i = 0; i < array.length - 1; i++) {
            int minNum = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minNum]) {
                    minNum = j;
                }
            }
            swap(array, i, minNum);
        }
    }

    private void swap(int[] array, int i, int j) {
        int bridge = array[i];
        array[i] = array[j];
        array[j] = bridge;
    }

    private boolean isNullArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array not created");
        }
        return false;
    }
}
