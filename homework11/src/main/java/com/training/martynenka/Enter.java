package com.training.martynenka;

import java.util.Scanner;

public class Enter {
    private static final String INQUIRY = "Commands: some string -> add hierarchy; "
            + "\n\t\t  \"print\" -> write hierarchy "
            + "\n\t\t  \"write\" -> to write in file "
            + "\n\t\t  \"read\" -> to read from file "
            + "\n\t\t  \"exit\" -> to exit";

    private Enter() {

    }

    public static String requestInput() {
        System.out.println(INQUIRY);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
