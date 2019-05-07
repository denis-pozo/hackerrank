package org.pozopardo.challenges.hackerrank.common.data.structure;

import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class UniqueIntegersDequeTest {

        private static final String USECASE_FILENAME = "/unique-integers-case.txt";

        @Test
        public void uniqueIntegersDequeTestForBigDatasets(){
            InputStream streamTest = getClass().getResourceAsStream(USECASE_FILENAME);

            Scanner scan = new Scanner(streamTest);
            int result = UniqueIntegersDeque.maxNumberOfUnique(scan);
            assertEquals(94055, result);
            scan.close();
        }
}
