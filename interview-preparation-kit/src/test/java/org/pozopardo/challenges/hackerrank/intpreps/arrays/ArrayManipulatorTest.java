package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ArrayManipulatorTest {

    final static private String USECASE_FILENAME = "/array-manipulation-case2.txt";

    @Test
    public void useCaseFromSite(){
        InputStream inputTest = getClass().getResourceAsStream(USECASE_FILENAME);
        Scanner scanner = new Scanner(inputTest);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long expected = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = ArrayManipulator.arrayManipulation(n, queries);
        assertEquals(expected, result);
        scanner.close();
    }
}
