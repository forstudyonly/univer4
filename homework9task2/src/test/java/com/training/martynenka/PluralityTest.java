package com.training.martynenka;


import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PluralityTest {
    private Plurality<String> plurality1 = new Plurality<String>();
    private Plurality<String> plurality2 = new Plurality<String>();
    private Plurality<String> pluralityUnion = new Plurality<String>();
    private Plurality<String> pluralityIntersection = new Plurality<String>();
    private Plurality<String> pluralityMinus = new Plurality<String>();
    private Plurality<String> pluralityDifference = new Plurality<String>();
    private final String A = "a";
    private final String B = "b";
    private final String C = "c";

    @Before
    public void init() {
        plurality1.clear();
        plurality1.add(A);
        plurality1.add(B);
        plurality2.clear();
        plurality2.add(B);
        plurality2.add(C);
        pluralityUnion.clear();
        pluralityUnion.add(A);
        pluralityUnion.add(B);
        pluralityUnion.add(C);
        pluralityIntersection.clear();
        pluralityIntersection.add(B);
        pluralityMinus.clear();
        pluralityMinus.add(A);
        pluralityDifference.clear();
        pluralityDifference.add(A);
        pluralityDifference.add(C);
    }

    @Test
    public void unionTest() {
        plurality1.union(plurality2);
        Assert.assertEquals(plurality1.size(), pluralityUnion.size());
        for (String string : plurality1) {
            Assert.assertEquals(true, pluralityUnion.contains(string));
        }
    }

    @Test
    public void intersectionTest() {
        plurality1.intersection(plurality2);
        Assert.assertArrayEquals(plurality1.toArray(), pluralityIntersection.toArray());
    }

    @Test
    public void minusTest() {
        plurality1.minus(plurality2);
        Assert.assertArrayEquals(plurality1.toArray(), pluralityMinus.toArray());
    }

    @Test
    public void differenceTest() {
        plurality1.difference(plurality2);
        Assert.assertArrayEquals(plurality1.toArray(), pluralityDifference.toArray());
    }
}