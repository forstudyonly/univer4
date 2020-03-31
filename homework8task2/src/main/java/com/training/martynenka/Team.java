package com.training.martynenka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team implements Comparable<Team> {
    private String name;
    private ArrayList<Worker> workers = new ArrayList<Worker>();

    public Team(String name) {
        this.name = name;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public ArrayList<Worker> getWorkers() {
        return (ArrayList<Worker>) workers.clone();
    }

    public int getEmployeePay() {
        int sum = 0;
        for (Worker worker : workers) {
            sum += worker.getPayment();
        }
        return sum;
    }

    public HashMap<Skills, Integer> calcSkillsOnTeam() {
        HashMap<Skills, Integer> teamSkills = new HashMap<Skills, Integer>();
        for (Worker worker : workers) {
            for (Skills skill : worker.getSkills()) {
                if (!teamSkills.containsKey(skill)) {
                    teamSkills.put(skill, 1);
                } else {
                    int countOfThisSkill = teamSkills.get(skill);
                    countOfThisSkill++;
                    teamSkills.put(skill, countOfThisSkill);
                }
            }
        }
        return teamSkills;
    }

    @Override
    public int compareTo(Team teamToCompare) {
        return getEmployeePay() - teamToCompare.getEmployeePay();
    }

    @Override
    public String toString() {
        StringBuilder stringTeam = new StringBuilder();
        stringTeam.append(name + " " + getEmployeePay());
        for (int i = 0; i < workers.size(); i++) {
            stringTeam.append("\n" + workers.get(i));
        }
        return stringTeam.toString();
    }
}
