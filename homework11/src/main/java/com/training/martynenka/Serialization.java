package com.training.martynenka;

import java.io.*;
import java.io.File;

public class Serialization {
    private static String filePath = "src/main/java/com/training/antonov/hierarchy.ser";
    private static File file = new File(filePath);

    private Serialization() {

    }

    public static boolean serialize(Folder folder) {
        try {
            ifFileNotExistCreateNew(file);
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(folder);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Folder deserialize() {
        try {
            if (!file.exists()) {
                throw new IOException("file not created yet");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Folder) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void ifFileNotExistCreateNew(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
