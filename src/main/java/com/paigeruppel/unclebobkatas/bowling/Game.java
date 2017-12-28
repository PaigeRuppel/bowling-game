package com.paigeruppel.unclebobkatas.bowling;

public class Game {


    private int score;

    public void add(int pins) {
        score += pins;
    }

    public int getScore() {
        return score;
    }
}
