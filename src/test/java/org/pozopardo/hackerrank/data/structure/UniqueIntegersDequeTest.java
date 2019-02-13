package org.pozopardo.hackerrank.data.structure;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class UniqueIntegersDequeTest {

        private static final String USECASE_FILENAME = "unique-integers-case.txt";

        @Test
        public void uniqueIntegersDequeTestForBigDatasets(){
            try{
                File fileTest = new File("src/test/resources/" + USECASE_FILENAME);
                Scanner scan = new Scanner(fileTest);
                int result = UniqueIntegersDeque.maxNumberOfUnique(scan);
                assertEquals(94055, result);
                scan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
}
