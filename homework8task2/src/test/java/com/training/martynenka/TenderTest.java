package com.training.martynenka;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class TenderTest {
    private Skills DIG;
    private Skills BUILD;
    private Skills BREAK;
    private Skills PLASTER;
    private Skills WALLPAPERING;

    private final int _900 = 900;
    private final int _1000 = 1000;
    private final int _1100 = 1100;
    private final int _3000 = 3000;
    private final int _3300 = 3300;

    private Tender library;
    private Tender library1;
    private Tender library2;
    private Tender library3;
    private final int COUNT_OF_TEAMS = 3;
    private ArrayList<Team> teams;
    private final int COUNT_OF_WORKERS = 3;
    private Worker[][] workers;

    @Before
    public void init() {
        DIG = Skills.DIG;
        BUILD = Skills.BUILD;
        BREAK = Skills.BREAK;
        PLASTER = Skills.PLASTER;
        WALLPAPERING = Skills.WALLPAPERING;

        teams = new ArrayList<Team>();
        workers = new Worker[COUNT_OF_TEAMS][COUNT_OF_WORKERS];
        workers[0][0] = new Worker("Вася", _1000);
        workers[0][0].addSkill(DIG);
        workers[0][0].addSkill(BREAK);

        workers[0][1] = new Worker("Петя", _1000);
        workers[0][1].addSkill(BREAK);

        workers[0][2] = new Worker("Вова", _1000);
        workers[0][2].addSkill(DIG);
        workers[0][2].addSkill(WALLPAPERING);

        workers[1][0] = new Worker("Вася", _900);
        workers[1][0].addSkill(DIG);
        workers[1][0].addSkill(BREAK);

        workers[1][1] = new Worker("Петя", _900);

        workers[1][2] = new Worker("Вова", _900);
        workers[1][2].addSkill(DIG);
        workers[1][2].addSkill(WALLPAPERING);

        workers[2][0] = new Worker("Вася", _1100);
        workers[2][0].addSkill(DIG);
        workers[2][0].addSkill(BREAK);

        workers[2][1] = new Worker("Петя", _1100);
        workers[2][1].addSkill(BREAK);

        workers[2][2] = new Worker("Вова", _1100);
        workers[2][2].addSkill(DIG);
        workers[2][2].addSkill(BREAK);

        for (int i = 0; i < COUNT_OF_TEAMS; i++) {
            teams.add(new Team("Team" + i));
            for (int j = 0; j < COUNT_OF_WORKERS; j++) {
                teams.get(i).addWorker(workers[i][j]);
            }
        }

        library = new Tender("Строительство библиотеки", _3000);
        library.addRequirement(DIG, 1);
        library.addRequirement(BREAK, 3);

        library1 = new Tender("Строительство библиотеки", _3300);
        library1.addRequirement(DIG, 1);
        library1.addRequirement(BREAK, 3);

        library2 = new Tender("Строительство библиотеки", _3000);
        library2.addRequirement(DIG, 1);
        library2.addRequirement(BREAK, 2);

        library3 = new Tender("Строительство библиотеки", _3000);
        library3.addRequirement(DIG, 1);
        library3.addRequirement(BREAK, 1);
    }

    @Test
    public void chooseBrigadeTest0() {
        Team bestTeam = library.chooseBrigade(teams);
        System.out.println(library.toString());
        System.out.println(bestTeam + (library.isWork() == false ? " Cтроительство закрылось" : ""));
        Assert.assertEquals(false, library.isWork());
    }

    @Test
    public void chooseBrigadeTest1() {
        Team bestTeam = library1.chooseBrigade(teams);
        System.out.println(library1.toString());
        System.out.println(bestTeam + (library1.isWork() == false ? " Cтроительство закрылось" : ""));
        Assert.assertEquals(true, library1.isWork());
    }

    @Test
    public void chooseBrigadeTest2() {
        Team bestTeam = library2.chooseBrigade(teams);
        System.out.println(library2.toString());
        System.out.println(bestTeam + (library2.isWork() == false ? " Cтроительство закрылось" : ""));
        Assert.assertEquals(true, library2.isWork());
    }

    @Test
    public void chooseBrigadeTest3() {
        Team bestTeam = library3.chooseBrigade(teams);
        System.out.println(library3.toString());
        System.out.println(bestTeam + (library3.isWork() == false ? " Cтроительство закрылось" : ""));
        Assert.assertEquals(true, library3.isWork());
    }
}