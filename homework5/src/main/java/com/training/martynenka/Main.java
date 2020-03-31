package com.training.martynenka;

import java.util.Scanner;

public class Main {

    private static final String PRINT = "PRINT";
    private static final String EXIT = "EXIT";
    private static final String COMPLETION_OF_WORK = "Completion of work";
    private static final String SUCCESSFULLY_ADD = "Path added successfully";
    private static final String UNSUCCESSFULLY_ADD = "Something went wrong";

    public static void main(String[] args) {
        Hierarchy hierarchy = new Hierarchy();
        Folder folder = new Folder();
        boolean work = true;
        while (work) {
            work = whatToDo(folder, Enter.requestInput(), hierarchy);
        }
        System.out.println(COMPLETION_OF_WORK);
    }

    static boolean whatToDo(Folder folder, String choose, Hierarchy hierarchy) {
        if (choose.toUpperCase().compareTo(EXIT) == 0) {
            return false;
        } else if (choose.toUpperCase().compareTo(PRINT) == 0) {
            hierarchy.display(folder);
        } else {
            addNewPath(folder, choose, hierarchy);
        }
        return true;
    }

    static void addNewPath(Folder folder, String input, Hierarchy hierarchy) {
        if (hierarchy.add(folder, input)) {
            System.out.println(SUCCESSFULLY_ADD);
        } else {
            System.out.println(UNSUCCESSFULLY_ADD);
        }
    }
}
