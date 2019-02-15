package org.pozopardo.hackerrank.data.structure;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BitSetOperatorTest {

    private static String INPUT_FILE = "bitset-operator-input.txt";
    private static String OUTPUT_FILE= "bitset-operator-output.txt";

    @Test
    public void expectedResultsFromMatchShouldMatchReal(){

        int count = 1;
        try{
            File fileTest = new File("src/test/resources/" + INPUT_FILE);
            File fileResults = new File("src/test/resources/" + OUTPUT_FILE);

            Scanner scan = new Scanner(fileTest);
            Scanner scanResults = new Scanner(fileResults);

            int bitsetLength = scan.nextInt();
            BitSet b1 = new BitSet(bitsetLength);
            BitSet b2 = new BitSet(bitsetLength);
            List<BitSet> bitsets = new ArrayList<>();
            bitsets.add(b1);
            bitsets.add(b2);

            int nOperations = scan.nextInt();
            while (nOperations-- > 0) {
                String operation = scan.next("AND|SET|FLIP|OR|XOR");
                int leftArg = scan.nextInt();
                int rightArg = scan.nextInt();
                BitSetOperator.processOperation(operation, bitsets, leftArg, rightArg);

                int resultLeft = scanResults.nextInt();
                int resultRight = scanResults.nextInt();
                assertEquals(resultLeft, bitsets.get(0).cardinality());
                assertEquals(resultRight, bitsets.get(1).cardinality());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
