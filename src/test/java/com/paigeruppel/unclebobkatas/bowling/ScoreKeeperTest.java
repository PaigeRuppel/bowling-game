package com.paigeruppel.unclebobkatas.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScoreKeeperTest {

    private ScoreKeeper underTest;

    @Before
    public void setup() {
        underTest = new ScoreKeeper();
    }

    @Test
    public void shouldAddAThrow() {
        underTest.addThrow(9);
        assertThat(underTest.getScoreForFrame(1), is(9));
    }

    @Test
    public void shouldReturnScoreForFirstAndSecondSimpleFrames() {
        underTest.addThrow(4);
        underTest.addThrow(5);
        underTest.addThrow(7);
        underTest.addThrow(1);
        assertThat(underTest.getScoreForFrame(1), is(9));
        assertThat(underTest.getScoreForFrame(2), is(17));
    }

}
