package com.paigeruppel.unclebobkatas.bowling;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class GameTest {

    private Game underTest;

    @Test
    public void shouldReturnScoreAfterOneThrow() {
        underTest = new Game();
        assertThat(underTest.getScore(9), is(9));
    }
}
