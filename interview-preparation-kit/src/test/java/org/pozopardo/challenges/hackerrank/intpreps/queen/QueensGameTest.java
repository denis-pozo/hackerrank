package org.pozopardo.challenges.hackerrank.intpreps.queen;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueensGameTest {

    @Test
    public void ifBlocked_cellIsBlockedShouldBeTrue() {
        List<String> board = Arrays.asList(".", "#");
        boolean [][] blockedCells = QueensGame.extractBlockedCells(board);
        assertTrue(blockedCells[1][0]);
    }

    @Test
    public void ifFree_cellIsBlockedShouldBeFalse() {
        List<String> board = Arrays.asList(".", "#");
        boolean [][] blockedCells = QueensGame.extractBlockedCells(board);
        assertFalse(blockedCells[0][0]);
    }

    @Test
    public void ifOneFree_countUnblockedShouldReturnOne() {
        List<String> board = Arrays.asList(".", "#");
        boolean [][] blockedCells = QueensGame.extractBlockedCells(board);
        assertThat(QueensGame.countUnblockedCells(blockedCells), is(equalTo(1)));
    }

    @Test
    public void ifTwoFree_countUnblockedShouldReturnTwo() {
        List<String> board = Arrays.asList(". #", "# .");
        boolean [][] blockedCells = QueensGame.extractBlockedCells(board);
        assertThat(QueensGame.countUnblockedCells(blockedCells), is(equalTo(2)));
    }

    @Test
    public void ifThreeFree_countUnblockedShouldReturnThree() {
        List<String> board = Arrays.asList(". .", "# .");
        boolean [][] blockedCells = QueensGame.extractBlockedCells(board);
        assertThat(QueensGame.countUnblockedCells(blockedCells), is(equalTo(3)));
    }

    @Test
    public void ifZeroFree_countUnblockedShouldReturnZero() {
        List<String> board = Arrays.asList("# #", "# #");
        boolean [][] blockedCells = QueensGame.extractBlockedCells(board);
        assertThat(QueensGame.countUnblockedCells(blockedCells), is(equalTo(0)));
    }
}
