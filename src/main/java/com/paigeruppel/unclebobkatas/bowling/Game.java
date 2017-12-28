package com.paigeruppel.unclebobkatas.bowling;

public class Game {


    private ScoreKeeper scorer = new ScoreKeeper();
    private boolean isFirstThrow = true;
    private int currentFrame = 0;

    public void throwBall(int pins) {
        scorer.addThrow(pins);
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
        return scorer.getScoreForFrame(currentFrame);
    }


}
