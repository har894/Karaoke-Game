package com.example.singletone;

public class Team {
    private String name;
    private int score = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void plusScore() {
        score++;
    }
}
