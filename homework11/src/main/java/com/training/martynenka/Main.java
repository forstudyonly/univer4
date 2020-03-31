package com.training.martynenka;

public class Main {

    private static final String PRINT = "PRINT";
    private static final String EXIT = "EXIT";
    private static final String WRITE = "WRITE";
    private static final String READ = "READ";
    private static final String COMPLETION_OF_WORK = "Completion of work";
    private static final String SUCCESSFULLY_ADD = "Path added successfully";
    private static final String UNSUCCESSFULLY_ADD = "Something went wrong";
    private static final String SUCCESSFULLY_RECORDED = "Successfully recorded";
    private static final String NOT_RECORDED = "Not recorded";
    private static final String READ_SUCCESSFULLY = "Read successfully";
    private static Folder folder = new Folder();

    public static void main(String[] args) {
        Hierarchy hierarchy = new Hierarchy();
        boolean isWork = true;
        while (isWork) {
            isWork = whatToDo(Enter.requestInput(), hierarchy);
        }
        System.out.println(COMPLETION_OF_WORK);
    }

    private static boolean whatToDo(String choose, Hierarchy hierarchy) {
        if (choose.toUpperCase().equals(EXIT)) {
            return false;
        } else if (choose.toUpperCase().equals(PRINT)) {
            hierarchy.display(folder);
        } else if (choose.toUpperCase().equals(WRITE)) {
            serialize();
        } else if (choose.toUpperCase().equals(READ)) {
            deserialize();
        } else {
            addNewPath(choose, hierarchy);
        }
        return true;
    }

    private static void addNewPath(String input, Hierarchy hierarchy) {
        if (hierarchy.add(folder, input)) {
            System.out.println(SUCCESSFULLY_ADD);
        } else {
            System.out.println(UNSUCCESSFULLY_ADD);
        }
    }

    private static void serialize() {
        if (Serialization.serialize(folder)) {
            System.out.println(SUCCESSFULLY_RECORDED);
        } else {
            System.out.println(NOT_RECORDED);
        }
    }

    private static void deserialize() {
        Folder deserializationFolder = Serialization.deserialize();
        if (deserializationFolder != null) {
            folder = deserializationFolder;
            System.out.println(READ_SUCCESSFULLY);
        }
    }
}
