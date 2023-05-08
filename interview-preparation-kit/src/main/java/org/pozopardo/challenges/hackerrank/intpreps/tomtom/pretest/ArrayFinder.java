package org.pozopardo.challenges.hackerrank.intpreps.tomtom.pretest;

import java.util.*;

public class ArrayFinder {

    // Time Complexity O(n) or O(nlog(n))
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> a = new ArrayList<>();
        for(int i = 0 ; i < A.length ; i++) {
            if(A[i] > 0) a.add(A[i]);
        }

        if(a.size() == 0) {
            return 1;
        }

        Collections.sort(a);
        int result = 1;
        for(Integer number : a) {
            if(number == result)
                result++;
        }
        return result;
    }
}
