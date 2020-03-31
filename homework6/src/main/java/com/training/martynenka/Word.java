package com.training.martynenka;

public class Word implements Comparable<Word> {
    private String name;
    private char firstLetter;
    private int numberOfCoincidences;

    public Word(String name) {
        this.name = name.toLowerCase();
        firstLetter = name.toUpperCase().charAt(0);
        numberOfCoincidences = 1;
    }

    public String getName() {
        return name;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public int getNumberOfCoincidences() {
        return numberOfCoincidences;
    }

    public void met() {
        numberOfCoincidences++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        } else {
            return name.equals(((Word) obj).getName().toLowerCase());
        }
    }

    @Override
    public int compareTo(Word wordToCompare) {
        return name.compareTo(wordToCompare.name);
    }
}
