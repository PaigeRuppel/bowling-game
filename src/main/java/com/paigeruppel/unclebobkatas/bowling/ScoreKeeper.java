package com.paigeruppel.unclebobkatas.bowling;

public class ScoreKeeper {

    private int ball = 0;
    private int score;
    private int currentThrow;
    private static int MAX_THROWS = 21; // 2 throws for first 9 frames, 3 throws for 10th frame

    private int[] gameThrows = new int[MAX_THROWS];

    public void addThrow(int pins) {
        gameThrows[currentThrow++] = pins;
    }

    public int getScoreForFrame(int frame) {
        score = 0;
        ball = 0;
        for (int f = 0; f < frame; f++) {
            if (isAStrike()) {
                score += 10 + nextTwoThrowsForStrike();
                ball++;
            } else if (isASpare()) {
                score += 10 + nextThrowForSpare();
                ball += 2;
            } else {
                score += nextTwoThrowsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private boolean isAStrike() {
        return gameThrows[ball] == 10;
    }

    private int nextTwoThrowsForStrike() {
        return gameThrows[ball + 1] + gameThrows[ball + 2];
    }

    private boolean isASpare() {
        return gameThrows[ball] + gameThrows[ball + 1] == 10;
    }

    private int nextThrowForSpare() {
        return gameThrows[ball + 2];
    }

    private int nextTwoThrowsInFrame() {
        return gameThrows[ball] + gameThrows[ball + 1];
    }
}
