package org.pozopardo.challenges.hackerrank.common.exception;

import java.util.Scanner;

public class MyCalculator {


    public static void main(String[] args) {
        MyCalculator my_calculator = new MyCalculator();
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private long power(int n, int p) throws Exception {
        if(n < 0 || p < 0 ) {
            throw new Exception("n or p should not be negative.");
        }
        if(n == 0 && p == 0 ) {
            throw new Exception("n and p should not be zero.");
        }
        return (long) Math.pow(n, p);
    }
}
