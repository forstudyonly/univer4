package com.training.martynenka;

import java.util.HashSet;

public class Plurality<E> extends HashSet<E> {
    public Plurality() {
        super();
    }

    public Plurality(Plurality<E> plurality) {
        super(plurality);
    }

    public void union(Plurality<E> addedSet) {
        for (E element : addedSet) {
            if (!containsElement(this, element)) {
                this.add(element);
            }
        }
    }

    public void intersection(Plurality<E> intersectSet) {
        manipulatePluralities(this, intersectSet, true);
    }

    public void minus(Plurality<E> minusSet) {
        manipulatePluralities(minusSet, this, false);
    }

    public void difference(Plurality<E> set) {
        Plurality<E> copyOfThis = new Plurality<E>(this);
        Plurality<E> copyOfSet = new Plurality<E>(set);
        this.minus(set);
        copyOfSet.minus(copyOfThis);
        this.addAll(copyOfSet);
    }

    private void manipulatePluralities(Plurality<E> firstPlurality, Plurality<E> secondPlurality, boolean isContain) {
        Plurality<E> manipulateResult = new Plurality<E>();
        for (E element : secondPlurality) {
            if (containsElement(firstPlurality, element) == isContain) {
                manipulateResult.add(element);
            }
        }
        this.clear();
        this.addAll(manipulateResult);
    }

    private boolean containsElement(Plurality<E> plurality, E element) {
        return plurality.contains(element);
    }
}
