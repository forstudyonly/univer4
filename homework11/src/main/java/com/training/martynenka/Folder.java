package com.training.martynenka;

import javafx.beans.binding.StringBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class Folder implements Serializable {
    private String name;
    private ArrayList<File> files = new ArrayList<File>();
    private ArrayList<Folder> folders = new ArrayList<Folder>();

    public Folder() {

    }

    public Folder(String name) {
        this.name = name;
    }

    /*public Boolean addHierarchy(String path) {
        return Hierarchy.add(this, path);
    }*/

    public String getName() {
        return name;
    }

    public int getCountOfFolders() {
        return folders.size();
    }

    public int getCountOfFiles() {
        return files.size();
    }

    public Folder getFolderByIndex(int index) {
        return folders.get(index);
    }

    public File getFileByIndex(int index) {
        return files.get(index);
    }

    public void addFolder(Folder folderToAdd) {
        folders.add(folderToAdd);
    }

    public void addFile(File fileToAdd) {
        files.add(fileToAdd);
    }

    @Override
    public String toString() {
        StringBuilder hierarchy = new StringBuilder();
        int numberOfSpaces = 0;
        if (name != null) {
            hierarchy.append(getStringWithSpaces(name, numberOfSpaces));
            numberOfSpaces++;
        }
        for (int i = 0; i < this.getCountOfFolders(); i++) {
            hierarchy.append(getStringInternalFolder(this.folders.get(i), numberOfSpaces));
        }
        for (int i = 0; i < this.getCountOfFiles(); i++) {
            hierarchy.append(getStringFile(this.files.get(i), numberOfSpaces));
        }
        return hierarchy.toString();
    }

    private StringBuilder getStringInternalFolder(Folder folder, int numberOfSpaces) {
        StringBuilder hierarchy = new StringBuilder();
        hierarchy.append(getStringWithSpaces(folder.getName(), numberOfSpaces));
        for (int i = 0; i < folder.getCountOfFolders(); i++) {
            hierarchy.append(getStringInternalFolder(folder.folders.get(i), numberOfSpaces + 1));
        }
        for (int i = 0; i < folder.getCountOfFiles(); i++) {
            hierarchy.append(getStringFile(folder.files.get(i), numberOfSpaces + 1));
        }
        return hierarchy;
    }

    private String getStringFile(File file, int numberOfSpaces) {
        return getStringWithSpaces(file.getName(), numberOfSpaces);
    }

    private String getStringWithSpaces(String str, int numberOfSpaces) {
        return new String(new char[numberOfSpaces]).replace("\0", " ") + str + "\n";
    }
}
