package com.training.martynenka;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hierarchy {

    public boolean add(Folder folder, String path) {
        path = getTrueWay(path);
        boolean result = isAllOkWithPath(path);
        if (result) {
            createFileOrFolder(folder, path);
        }
        return result;
    }

    public void display(Folder folder) {
        System.out.print(folder);
    }

    private void createFileOrFolder(Folder folder, String path) {
        String[] names = splitFolder(path);
        if (isFile(names)) {
            createFile(folder, names);
        } else {
            createFolder(folder, names);
        }
    }

    private void createFolder(Folder folder, String[] names) {
        int indexOfExistFolder = getIndexOfFolder(folder, names[0]);
        if (indexOfExistFolder != -1) {
            if (names.length == 2) { //есть еще папки на добавление
                add(folder.getFolderByIndex(indexOfExistFolder), names[1]);
            }
        } else {
            folder.addFolder(new Folder(names[0]));
            if (names.length == 2) {
                add(folder.getFolderByIndex(folder.getCountOfFolders() - 1), names[1]);
            }
        }
    }

    private void createFile(Folder folder, String[] names) {
        if (getIndexOfFile(folder, names[0]) == -1) {
            folder.addFile(new File((names[0])));
        }
    }

    private int getIndexOfFolder(Folder folder, String name) {
        for (int i = 0; i < folder.getCountOfFolders(); i++) {
            if (folder.getFolderByIndex(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexOfFile(Folder folder, String name) {
        for (int i = 0; i < folder.getCountOfFiles(); i++) {
            if (folder.getFileByIndex(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isFile(String[] names) {
        return names.length == 1 && names[0].contains(".");
    }

    private String[] splitFolder(String path) {
        List<String> divided = new LinkedList<String>(Arrays.asList(path.split("\\\\", 2)));
        divided.removeAll(Arrays.asList("", null));
        return divided.toArray(new String[divided.size()]);
    }

    private String getTrueWay(String path) {
        if (path.contains("/")) {
            return path.replace("/", "\\");
        }
        return path;
    }

    private boolean isAllOkWithPath(String path) {
        return isFileInTheEnd(path)
                && !isPathEmpty(path)
                && !isFolderConsistsOfSpaces(path)
                && !isFolderContainsForbiddenCharacters(path);
    }

    private boolean isFileInTheEnd(String path) {
        String[] foldersAndFile = path.split("\\\\");
        for (int i = 0; i < foldersAndFile.length; i++) {
            if (foldersAndFile[i].indexOf(".") != -1 && i != foldersAndFile.length - 1) { //содержит точку и не последний элемент
                return false;
            }
        }
        return true;
    }

    private boolean isPathEmpty(String path) {
        return path.equals("");
    }

    private boolean isFolderConsistsOfSpaces(String path) {
        String[] foldersAndFile = path.split("\\\\");
        for (int i = 0; i < foldersAndFile.length; i++) {
            if (foldersAndFile[i].matches("^[ ]*$")) {
                return true;
            }
        }
        return false;
    }

    private boolean isFolderContainsForbiddenCharacters(String path) {
        if (path.matches(".*[\\\\]{2,}.*")) {
            return true;
        }
        String[] foldersAndFile = path.split("\\\\", 2);
        for (int i = 0; i < foldersAndFile.length; i++) {
            if (foldersAndFile[i].matches(".*[|/\"<>?*].*")) {
                return true;
            }
        }
        return false;
    }
}
