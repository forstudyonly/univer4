package com.training.martynenka;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FolderTest {

    private Folder folder;
    private Hierarchy hierarchy;
    private final String PATH = "vova/antonov/text.txt";
    private final String PATH_1 = "vova/antonov/text1.txt";
    private final String FILE = "text.txt";
    private final String FILE_1 = "text1.txt";
    private final String BAD_PATH_1 = "vova/antonov/text.txt/folder";
    private final String BAD_PATH_2 = "vova/antonov/      /path";
    private final String BAD_PATH_3 = "vova/antonov/tex*t.txt";
    private final String BAD_PATH_4 = "vova/antonov//text.txt";

    @Before
    public void init() {
        folder = new Folder();
        hierarchy = new Hierarchy();
    }

    @Test
    public void addNormHierarchyTest() {
        Assert.assertEquals(true, hierarchy.add(folder, PATH));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(0, folder.getCountOfFiles());
    }

    @Test
    public void addTwoTimeNormHierarchyTest() {
        Assert.assertEquals(true, hierarchy.add(folder, PATH));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(0, folder.getCountOfFiles());
        Assert.assertEquals(true, hierarchy.add(folder, PATH));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(0, folder.getCountOfFiles());
    }

    @Test
    public void addTwoTimeNormHierarchyTest2() {
        Assert.assertEquals(true, hierarchy.add(folder, PATH));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(0, folder.getCountOfFiles());
        Assert.assertEquals(true, hierarchy.add(folder, PATH_1));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(0, folder.getCountOfFiles());
    }

    @Test
    public void addTwoTimeFileTest() {
        Assert.assertEquals(true, hierarchy.add(folder, FILE));
        Assert.assertEquals(0, folder.getCountOfFolders());
        Assert.assertEquals(1, folder.getCountOfFiles());
        Assert.assertEquals(true, hierarchy.add(folder, FILE));
        Assert.assertEquals(0, folder.getCountOfFolders());
        Assert.assertEquals(1, folder.getCountOfFiles());
    }

    @Test
    public void addTwoFileTest() {
        Assert.assertEquals(true, hierarchy.add(folder, FILE));
        Assert.assertEquals(0, folder.getCountOfFolders());
        Assert.assertEquals(1, folder.getCountOfFiles());
        Assert.assertEquals(true, hierarchy.add(folder, FILE_1));
        Assert.assertEquals(0, folder.getCountOfFolders());
        Assert.assertEquals(2, folder.getCountOfFiles());
    }

    @Test
    public void addHierarchyAndFileTest() {
        Assert.assertEquals(true, hierarchy.add(folder, PATH));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(0, folder.getCountOfFiles());
        Assert.assertEquals(true, hierarchy.add(folder, FILE_1));
        Assert.assertEquals(1, folder.getCountOfFolders());
        Assert.assertEquals(1, folder.getCountOfFiles());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals(true, hierarchy.add(folder, PATH));
        Assert.assertEquals(true, hierarchy.add(folder, FILE));
        Assert.assertEquals("vova\n antonov\n  text.txt\ntext.txt\n", folder.toString());
    }

    @Test
    public void addBadHierarchy1Test() {
        Assert.assertEquals(false, hierarchy.add(folder, BAD_PATH_1));
    }

    @Test
    public void addBadHierarchy2Test() {
        Assert.assertEquals(false, hierarchy.add(folder, BAD_PATH_2));
    }

    @Test
    public void addBadHierarchy3Test() {
        Assert.assertEquals(false, hierarchy.add(folder, BAD_PATH_3));
    }

    @Test
    public void addBadHierarchy4Test() {
        Assert.assertEquals(false, hierarchy.add(folder, BAD_PATH_4));
    }
}