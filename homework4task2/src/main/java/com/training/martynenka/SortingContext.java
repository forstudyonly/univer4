package com.training.martynenka;

public class SortingContext {
    private Sorter sorterMethod;

    public SortingContext(Sorter sorterMethod) {
        isNullSorter(sorterMethod);
        this.sorterMethod = sorterMethod;
    }

    public void execute(int[] array) {
        sorterMethod.sort(array);
    }

    private boolean isNullSorter(Sorter sorter) {
        if (sorter == null) {
            throw new IllegalArgumentException("Method not created");
        }
        return false;
    }
}
