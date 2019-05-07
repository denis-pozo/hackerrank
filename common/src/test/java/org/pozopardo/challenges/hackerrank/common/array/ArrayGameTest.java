package org.pozopardo.challenges.hackerrank.common.array;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ArrayGameTest {

    private static final String USECASE_FILENAME = "/test-case-array-game.txt";
    private static final String RESULTS_FILENAME = "/results-test-case-array-game.txt";

    private static final Object[] getWinningGames() {
        return new Object[]{
                new Object[]{new int[]{0, 0, 0, 0, 0}, 3},
                new Object[]{new int[]{0, 0, 0, 1, 1}, 5},
                new Object[]{new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1}, 4},
                new Object[]{new int[]{0, 1, 0, 1, 0, 1}, 2},
                new Object[]{new int[]{0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1}, 17},
                new Object[]{new int[]{0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1}, 17},
            new Object[]{new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, 3}
        };
    }

    private static final Object[] getLoosingGames() {
        return new Object[]{
                new Object[]{new int[]{0, 0, 1, 1, 1, 0}, 3},
                new Object[]{new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, 6},
                new Object[]{new int[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1}, 22},
                new Object[]{new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, 27},
                new Object[]{new int[]{0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1}, 8},
                new Object[]{new int[]{0, 1, 1, 1}, 2},
                new Object[]{new int[]{0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0}, 8},
                new Object[]{new int[]{0, 1, 0}, 1}
        };
    }

    @Test
    @Parameters(method = "getWinningGames")
    public void canWinShouldBeTrueForWinningGames(int [] game, int leap) {

        assertTrue(ArrayGame.canWin(leap, game));
    }

    @Test
    @Parameters(method = "getLoosingGames")
    public void canWinShouldBeFalseForLoosingGames(int [] game, int leap) {

        assertFalse(ArrayGame.canWin(leap, game));
    }

    @Test
    public void expectedResultsFromMatchShouldMatchReal(){

        int count = 1;

        InputStream inputTest = getClass().getResourceAsStream(USECASE_FILENAME);
        InputStream inputResult = getClass().getResourceAsStream(RESULTS_FILENAME);

        Scanner scan = new Scanner(inputTest);
        Scanner scanResults = new Scanner(inputResult);

        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            String expected = scanResults.next("YES|NO");
            String result = ArrayGame.canWin(leap, game) ? "YES" : "NO";
            System.out.println(count++ + ": Expected " + expected + " Result " + result);
            String message = "Game " + game + "\nLeap " + leap;
            assertEquals(message, expected, result);
        }
        scan.close();
    }

}
