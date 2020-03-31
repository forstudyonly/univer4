package com.training.martynenka;

import java.util.*;

public class Tender {
    private String title;
    private int budget;
    private HashMap<Skills, Integer> requirements = new HashMap<Skills, Integer>();
    private boolean isWork = false;

    public Tender(String title, int budget) {
        this.title = title;
        this.budget = budget;
    }

    public void addRequirement(Skills skill, int amountOfWorkers) {
        requirements.put(skill, amountOfWorkers);
    }

    public Team chooseBrigade(ArrayList<Team> teams) {
        isWork = true;
        ArrayList<Team> suitableTeams = chooseSuitableTeams(teams);
        if (suitableTeams.size() != 0) {
            Collections.sort(suitableTeams); //сортируем по стоимости
            return suitableTeams.get(0);
        }
        isWork = false;
        return null;
    }

    public boolean isWork() {
        return isWork;
    }

    private ArrayList<Team> chooseSuitableTeams(ArrayList<Team> teams) {
        ArrayList<Team> suitableTeams = new ArrayList<Team>();
        for (Team team : teams) {
            if (isSuitableTeam(team)) {
                suitableTeams.add(team);
            }
        }
        return suitableTeams;
    }

    private boolean isSuitableTeam(Team team) {
        if (team.getEmployeePay() > budget) {
            return false;
        }
        HashMap<Skills, Integer> teamSkills = team.calcSkillsOnTeam(); //навык и его количество в команде
        if (isSuitableSkills(teamSkills)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringTender = new StringBuilder();
        stringTender.append(title + " " + budget);
        Iterator<Map.Entry<Skills, Integer>> iterator = requirements.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Skills, Integer> entry = iterator.next();
            stringTender.append("\n" + entry.getKey() + " " + entry.getValue());
        }
        return stringTender.toString();
    }

    private boolean isSuitableSkills(HashMap<Skills, Integer> teamSkills) {
        boolean isCorresponds = true;
        Iterator<Map.Entry<Skills, Integer>> iterator = requirements.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Skills, Integer> entry = iterator.next();
            if (allGoodWithThisSkill(teamSkills, entry)) {
                isCorresponds = false;
            }
        }
        return isCorresponds;
    }

    private boolean allGoodWithThisSkill(HashMap<Skills, Integer> teamSkills, Map.Entry<Skills, Integer> entry) {
        return teamSkills.containsKey(entry.getKey()) && !(requirements.get(entry.getKey()) <= teamSkills.get(entry.getKey()));
    }
}
