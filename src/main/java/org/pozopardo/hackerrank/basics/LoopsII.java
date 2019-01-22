package org.pozopardo.hackerrank.basics;

public class LoopsII {
    public static void main (String [] args) {
        print(calculateSeries(0, 2, 10));
        print(calculateSeries(5, 3, 5));
        print(calculateSeries(0, 0, 4));
        print(calculateSeries(9, 0, 5));
        print(calculateSeries(0, 2, 3));
        print(calculateSeries(5, 3, 1));
        print(calculateSeries(50, 50, 15));
    }

    private static void print(int [] serie) {
        for(Integer i : serie) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int [] calculateSeries(int a, int b, int n) {
        int [] bTerms = new int[n];

        for(int i = 0 ; i < bTerms.length ; i++) {
            bTerms[i] = (int) (b * Math.pow(2, i));
        }

        int s = a;
        int [] result = new int[n];
        for(int i = 0 ; i < bTerms.length ; i++) {
            s = s + bTerms[i];
            result[i] = s;
        }
        return result;
    }
}
