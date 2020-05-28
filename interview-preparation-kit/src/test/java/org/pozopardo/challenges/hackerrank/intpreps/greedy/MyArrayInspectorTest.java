package org.pozopardo.challenges.hackerrank.intpreps.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyArrayInspectorTest {

    @Test
    public void verifySampleTestCase0() {
        int [] array = new int[]{3, -7, 0};
        assertEquals(3, MyArrayInspector.minimumAbsoluteDifference(array));
    }

    @Test
    public void verifySampleTestCase1() {
        int [] array = new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        assertEquals(1, MyArrayInspector.minimumAbsoluteDifference(array));
    }

    @Test
    public void verifySampleTestCase2() {
        int [] array = new int[]{1, -3, 71, 68, 17};
        assertEquals(3, MyArrayInspector.minimumAbsoluteDifference(array));
    }
}
