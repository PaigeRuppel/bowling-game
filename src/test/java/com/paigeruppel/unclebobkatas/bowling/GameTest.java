package com.paigeruppel.unclebobkatas.bowling;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;


public class GameTest {

    private Game underTest;

    @Before
    public void setup() {
        underTest = new Game();
    }
    @Test
    public void shouldReturnScoreAfterOneSimpleFrame() {
        underTest.throwBall(4);
        underTest.throwBall(5);
        assertThat(underTest.getCurrentFrame(), is(1));
        assertThat(underTest.getScore(), is(9));
    }

    @Test
    public void shouldReturnScoreAfterTwoSimpleFrames() {
        underTest.throwBall(4);
        underTest.throwBall(5);
        underTest.throwBall(7);
        underTest.throwBall(1);
        assertThat(underTest.getCurrentFrame(), is(2));
        assertThat(underTest.getScore(), is(17));
    }



    @Test
    public void shouldReturnScoreForSecondFrameWithSpareInFirstFrame() {
        underTest.throwBall(4);
        underTest.throwBall(6);
        underTest.throwBall(7);
        underTest.throwBall(1);
        assertThat(underTest.getCurrentFrame(), is(2));
        assertThat(underTest.getScore(), is(25));
    }

    @Test
    public void shouldReturnGameScoreWithSpareInFirstFrame() {
        underTest.throwBall(4);
        underTest.throwBall(6);
        underTest.throwBall(7);
        underTest.throwBall(1);
        assertThat(underTest.getCurrentFrame(), is(2));
        assertThat(underTest.getScore(), is(25));
    }

    @Test
    public void shouldReturnGameScoreWithStrikeInFirstFrame() {
        underTest.throwBall(10);
        underTest.throwBall(7);
        underTest.throwBall(1);
        assertThat(underTest.getCurrentFrame(), is(2));
        assertThat(underTest.getScore(), is(26));
    }

    @Test
    public void shouldReturnGameScoreWithStrikeFollowedBySpare() {
        underTest.throwBall(10);
        underTest.throwBall(4);
        underTest.throwBall(6);
        underTest.throwBall(3);
        underTest.throwBall(2);
        assertThat(underTest.getCurrentFrame(), is(3));
        assertThat(underTest.getScore(), is(38));
    }

    @Test
    public void shouldReturnPerfectGame300() {
        for (int i = 0; i <= 11; i++) {
            underTest.throwBall(10);
        }
        assertThat(underTest.getCurrentFrame(), is(10));
        assertThat(underTest.getScore(), is(300));
    }

    @Test
    public void shouldReturnScore299() {
        for (int i = 0; i < 11; i++) {
            underTest.throwBall(10);
        }
        underTest.throwBall(9);
        assertThat(underTest.getCurrentFrame(), is(10));
        assertThat(underTest.getScore(), is(299));
    }

    @Test
    public void shouldReturnScore133SampleGame1() {
        underTest.throwBall(1);
        underTest.throwBall(4);
        underTest.throwBall(4);
        underTest.throwBall(5);
        underTest.throwBall(6);
        underTest.throwBall(4);
        underTest.throwBall(5);
        underTest.throwBall(5);
        underTest.throwBall(10);
        underTest.throwBall(0);
        underTest.throwBall(1);
        underTest.throwBall(7);
        underTest.throwBall(3);
        underTest.throwBall(6);
        underTest.throwBall(4);
        underTest.throwBall(10);
        underTest.throwBall(2);
        underTest.throwBall(8);
        underTest.throwBall(6);
        assertThat(underTest.getScore(), is(133));
    }
}
