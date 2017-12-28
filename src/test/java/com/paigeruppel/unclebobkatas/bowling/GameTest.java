package com.paigeruppel.unclebobkatas.bowling;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class GameTest {

    private Game underTest;

    @Test
    public void shouldReturnScoreAfterOneSimpleFrame() {
        underTest = new Game();
        underTest.add(4);
        underTest.add(5);
        assertThat(underTest.getScore(), is(9));
    }

    @Test
    public void shouldReturnScoreAfterTwoSimpleFrames() {
        underTest = new Game();
        underTest.add(4);
        underTest.add(5);
        underTest.add(7);
        underTest.add(1);
        assertThat(underTest.getScore(), is(17));
    }
}
