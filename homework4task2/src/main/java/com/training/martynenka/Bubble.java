package com.training.martynenka;

public class Bubble implements Sorter {
    @Override
    public void sort(int[] array) {
        isNullArray(array);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
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
