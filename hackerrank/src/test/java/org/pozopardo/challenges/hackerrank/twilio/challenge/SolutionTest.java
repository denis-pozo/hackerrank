package org.pozopardo.challenges.hackerrank.twilio.challenge;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    static List<Integer> inputArray = Arrays.asList(new Integer[]{8, 5, 5, 5, 5, 5, 1, 1, 1, 4, 4});
    static List<Integer> outputArray = Arrays.asList(new Integer[]{8, 4, 4, 1, 1, 1, 5, 5, 5, 5, 5});

    @Test
    public void testCustomSort() {
        Sorter.customSort(inputArray);

        asserArrayElementsAreEqual(inputArray, outputArray);
    }

    private void asserArrayElementsAreEqual(List<Integer> inputArray, List<Integer> outputArray) {

        for(int i = 0 ; i < inputArray.size() ; i++) {
            System.out.println("i: " + i);
            assertEquals(outputArray.get(i), inputArray.get(i));
        }
    }
}
