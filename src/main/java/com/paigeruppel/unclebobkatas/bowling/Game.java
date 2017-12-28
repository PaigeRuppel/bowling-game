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
            isFirstThrow = false;
            adjustFrameAndResetThrowForStrike(pins);
        } else {
            isFirstThrow = true;
            advanceFrame();
        }
    }

    private void adjustFrameAndResetThrowForStrike(int pins) {
        if (pins == 10) {
            advanceFrame();
            isFirstThrow = true;
        }
    }

    private void advanceFrame() {
        currentFrame++;
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
