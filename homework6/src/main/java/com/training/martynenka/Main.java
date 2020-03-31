package com.training.martynenka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write some text: ");
        GroupingAndCounting groupingAndCounting = new GroupingAndCounting();
        System.out.println(groupingAndCounting.groupAndCount(sc.nextLine()));
    }
}
