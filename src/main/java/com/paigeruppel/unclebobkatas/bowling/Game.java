package com.paigeruppel.unclebobkatas.bowling;

public class Game {


    private int score;
    private int currentThrow;

    private static int MAX_THROWS = 21; // 2 throws for first 9 frames, 3 throws for 10th frame

    private int[] gameThrows = new int[MAX_THROWS];

    public void add(int pins) {
        gameThrows[currentThrow++] = pins;
        score += pins;
    }

    public int getScore() {
        return score;
    }

    public int getScoreForFrame(int frame) {
        int scoreForFrame = 0;
        for (int ball = 0; ball < currentThrow && frame > 0; ball+=2, frame--) {
            scoreForFrame += gameThrows[ball] + gameThrows[ball + 1];
        }
        return scoreForFrame;
    }
}
