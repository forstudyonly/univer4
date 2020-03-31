package com.training.martynenka;

import java.util.HashSet;
import java.util.Iterator;

public class Worker {
    private String nickname;
    private int payment;
    private HashSet<Skills> skills = new HashSet<Skills>();

    public Worker(String nickname, int payment) {
        this.nickname = nickname;
        this.payment = payment;
    }

    public void addSkill(Skills skill) {
        skills.add(skill);
    }

    public HashSet<Skills> getSkills() {
        return (HashSet<Skills>) skills.clone();
    }

    public int getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        StringBuilder stringWorker = new StringBuilder();
        stringWorker.append(nickname + " " + payment);
        Iterator iterator = skills.iterator();
        while (iterator.hasNext()) {
            stringWorker.append(" " + iterator.next());
        }
        return stringWorker.toString();
    }
}
