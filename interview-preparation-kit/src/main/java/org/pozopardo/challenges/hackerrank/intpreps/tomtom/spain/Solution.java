package org.pozopardo.challenges.hackerrank.intpreps.tomtom.spain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int solution(int[] A) {
        // Implement your solution here
        // Sort them all

        Arrays.sort(A);

        List<Integer> distances = new ArrayList<>();
        int max = 0;

        for (int i = 0 ; i < 50; i++) {
            int current = countIntegers(A, i);
            if(current > max) {
                max = current;
            }
        }
        return max;
    }

//    public int getMaxDistance(int []A) {
//        int max = 0;
//        for(int i=0; i<A.length; i++) {
//            A[i]
//
//        }
//    }

    public static int countIntegers(int [] A, int difference) {
        int count = 0;
        int lastInt = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastInt == 0) {
                if (A[i] - lastInt == difference) {
                    count++;
                }
            } else if (A[i] - lastInt % difference == 0) {
                if (A[i] - lastInt == difference) {
                    count++;
                }
            }
        }
        return count+1;
    }
}
