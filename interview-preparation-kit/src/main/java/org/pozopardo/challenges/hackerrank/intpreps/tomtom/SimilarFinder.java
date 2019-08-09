package org.pozopardo.challenges.hackerrank.intpreps.tomtom;

import java.util.*;

public class SimilarFinder {

    private static Map<Integer, Integer> factorialCache = new HashMap<>();

    public int numberOfSimilar(int N) {
        int result = 0;
        int length = 0;
        Map<Integer, Integer> occurrences = new HashMap<>();


        while(N > 0) {
            int n = N % 10;
            if( occurrences.get(n) == null ) occurrences.put(n, 1);
            else occurrences.put(n, occurrences.get(n) + 1);
            N = N / 10;
            length++;
        }

        result = factorial(length);

        for( Map.Entry<Integer, Integer> entry : occurrences.entrySet() ) {
            if ( entry.getValue() > 1 ) {
                result = result / factorial (entry.getValue());
            }
        }

        if(occurrences.get(0) != null) {
            int invalidResults = occurrences.get(0);
            result -= invalidResults;
        }

        return result;
    }

    private int factorial(int n) {
        if(factorialCache.size() < n) {
            if(factorialCache.size() <= 1) {
                factorialCache.put(0, 1);
                factorialCache.put(1, 1);
            }

            for ( int i = factorialCache.size() ; i <= n ; i++) {
                factorialCache.put(i, factorialCache.get(i-1) * i);
            }
        }
        return factorialCache.get(n);
    }

    public static void main(String[] args) {
        SimilarFinder sf = new SimilarFinder();
        System.out.println(sf.numberOfSimilar(100000));
    }
}
