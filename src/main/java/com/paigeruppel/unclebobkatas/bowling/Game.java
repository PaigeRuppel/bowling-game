package com.paigeruppel.unclebobkatas.bowling;

public class Game {


    private int score;
    private int currentThrow;
    private boolean isFirstThrow = true;
    private int currentFrame = 0;


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

        if (currentFrame > 10) {
            currentFrame = 10;
        }
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public int getScore() {
        return getScoreForFrame(currentFrame);
    }

    private int ball = 0;

    public int getScoreForFrame(int frame) {
        score = 0;
        ball = 0;
        for (int f = 0; f < frame; f++) {
            if (isAStrike()) {
                ball++;
                score += 10 + gameThrows[ball] + gameThrows[ball+1];
            } else if (isASpare()) {
                ball += 2;
                score += 10 + gameThrows[ball];
            } else {
                score += gameThrows[ball] + gameThrows[ball+1];
                ball += 2;
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
