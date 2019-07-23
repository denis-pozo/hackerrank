package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import org.junit.Test;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.pozopardo.challenges.hackerrank.intpreps.dictionaries.QueryManager.freqQuery;

public class QueryManagerTest {

    final static private String USECASE_FILENAME = "/query-manager-case10.txt";
    final static private String RESULTS_FILENAME = "/query-manager-result10.txt";

    @Test
    public void useCaseFromSite() {
        long startTime = System.currentTimeMillis();
        int [][] queries = loadQueries();
        List<Integer> results = QueryManager.freqQuery(queries);
        long endTime = System.currentTimeMillis();
        System.out.println("Duration: " + (endTime - startTime));
        int [] expected = loadResults();
        assertEquals(expected.length, results.size());
        for(int i = 0 ; i < expected.length ; i++) {
            assertEquals(expected[i],results.get(i).intValue());
        }
    }

    public static int [][] loadQueries() {
        InputStream inputStream = QueryManagerTest.class.getResourceAsStream(USECASE_FILENAME);
        Scanner scanner = new Scanner(inputStream);

        int q = scanner.nextInt();
        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }

        return queries;
    }

    public static int [] loadResults() {
        InputStream inputStream = QueryManagerTest.class.getResourceAsStream(RESULTS_FILENAME);
        Scanner scanner = new Scanner(inputStream);

        int q = scanner.nextInt();
        int[] results = new int[q];

        for (int i = 0; i < q; i++) {
            results[i] = scanner.nextInt();
        }

        return results;
    }
}
