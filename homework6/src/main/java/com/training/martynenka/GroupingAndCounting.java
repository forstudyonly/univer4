package com.training.martynenka;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class GroupingAndCounting {
    private final String SPACE = " ";
    private final String REGEX_PUNCTUATION_MARKS = "[!?,.:;()\"\"–]";
    private final String EMPTY_STRING = "";
    private final String HYPHEN = "-";
    private final String COLONS_WITH_SPACE = ":  ";
    private final String TAB = "\t";
    private final String ENTER = "\n";

    public String groupAndCount(String text) {
        text = removePunctuationMarks(text);
        ArrayList<String> words = splitTextIntoWords(text);
        Map<Character, List<Word>> groupWords = countAndGroupsWords(words);
        sortInGroups(groupWords);
        return getString(groupWords);
    }

    private Map<Character, List<Word>> countAndGroupsWords(ArrayList<String> words) {
        ArrayList<Word> wordProcessing = new ArrayList<Word>();
        for (int i = 0; i < words.size(); i++) {
            int wordNumber = wordProcessing.indexOf(new Word(words.get(i)));
            if (wordNumber != -1) { //если слово еще не встречалось
                wordProcessing.get(wordNumber).met();
            } else {
                wordProcessing.add(new Word(words.get(i)));
            }
        }
        return new TreeMap<Character, List<Word>>(wordProcessing.stream().collect(
                Collectors.groupingBy(Word::getFirstLetter)));
    }

    private void sortInGroups(Map<Character, List<Word>> groupWords) {
        for (Map.Entry<Character, List<Word>> item : groupWords.entrySet()) {
            Collections.sort(item.getValue());
        }
    }

    private String getString(Map<Character, List<Word>> groupWords) {
        StringBuilder grouping = new StringBuilder();
        for (Map.Entry<Character, List<Word>> item : groupWords.entrySet()) {
            grouping.append(item.getKey() + COLONS_WITH_SPACE);
            boolean first = true; //первое ли слово с таким ключом
            for (Word word : item.getValue()) {
                if (first) {
                    first = false;
                    grouping.append(word.getName() + SPACE + word.getNumberOfCoincidences() + ENTER);
                } else {
                    grouping.append(TAB + word.getName() + SPACE + word.getNumberOfCoincidences() + ENTER);
                }
            }
        }
        return grouping.toString();
    }

    private String removePunctuationMarks(String text) {
        return text.replaceAll(REGEX_PUNCTUATION_MARKS, SPACE);
    }

    private ArrayList<String> splitTextIntoWords(String text) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(SPACE)));
        words.removeAll(Arrays.asList(EMPTY_STRING, null, HYPHEN));
        return words;
    }
}
