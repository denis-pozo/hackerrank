package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import org.junit.Test;
import org.pozopardo.challenges.hackerrank.intpreps.arrays.ArrayManipulator;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class StringComparatorTest {

    final static private String USECASE_FILENAME = "/string-comparator-case5.txt";

    @Test
    public void useCaseFromSite(){
        InputStream inputTest = getClass().getResourceAsStream(USECASE_FILENAME);
        Scanner scanner = new Scanner(inputTest);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();
            String s3 = scanner.nextLine();

            String result = StringComparator.twoStrings(s1, s2);
            assertEquals(s3, result);
        }

        scanner.close();
    }
}
