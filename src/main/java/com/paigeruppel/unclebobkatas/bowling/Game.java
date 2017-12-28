package com.paigeruppel.unclebobkatas.bowling;

public class Game {


    private int score;
    private int currentThrow;
    private int currentFrame;
    private int ball;

    private static int MAX_THROWS = 21; // 2 throws for first 9 frames, 3 throws for 10th frame

    private int[] gameThrows = new int[MAX_THROWS];

    public void add(int pins) {
        gameThrows[currentThrow++] = pins;
        currentFrame = currentThrow / 2;
        score += pins;
    }

    public int getScore() {
        return getScoreForFrame(currentFrame);
    }

    public int getScoreForFrame(int frame) {
        int score = 0;
        for (ball = 0; ball < currentThrow && frame > 0; ball+=2, frame--) {
            int firstThrow = gameThrows[ball];
            int secondThrow = gameThrows[ball + 1];
            int frameScore = firstThrow + secondThrow;
            if (isASpare()) {
                score += frameScore + gameThrows[ball + 2];
            } else {
                score += frameScore;
            }
        }
        return score;
    }

    private boolean isASpare() {
        return gameThrows[ball] + gameThrows[ball + 1] == 10;
    }
}
