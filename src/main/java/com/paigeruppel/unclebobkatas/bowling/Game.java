package com.paigeruppel.unclebobkatas.bowling;

public class Game {


    private int score;
    private int currentThrow;
    private boolean isFirstThrow = true;
    private int currentFrame = 0;

    private int ball;

    private static int MAX_THROWS = 21; // 2 throws for first 9 frames, 3 throws for 10th frame

    private int[] gameThrows = new int[MAX_THROWS];

    public void throwBall(int pins) {
        gameThrows[currentThrow++] = pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (isFirstThrow) {
            if (pins == 10) {
                currentFrame++;
            } else {
                isFirstThrow = false;
            }
        } else {
            isFirstThrow = true;
            currentFrame++;
        }
    }

    public int getCurrentFrame() {
        return currentFrame;
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
            if (firstThrow == 10) {
                score += frameScore + gameThrows[ball+1] + gameThrows[ball+2];
            } else if (isASpare()) {
                score += frameScore + gameThrows[ball + 2];
            } else {
                score += frameScore;
            }
        }
        return score;
    }

    private boolean isAStrike() {
        return gameThrows[ball] == 10;
    }


    private boolean isASpare() {
        return gameThrows[ball] + gameThrows[ball + 1] == 10;
    }
}
