package org.pozopardo.challenges.epi.primitive;

/* 5.7 COMPUTE X^Y
 *
 * Problem 5.7: Write a function that takes a double x and an integer y
 * and returns x^y. Assume addition, multiplication, and division take constant
 * time. You cannot use any functions, except for those you write yourself. You
 * can ignore overflow and underflow.
 */

public class PowerCalculator {

    public static double calculate (double base, int power) {
        if(power == 0) return 1.0;
        if(power == 1) return base;

        double result = base;
        for(int i = 1 ; i < power ; i++) {
            result = result * base;
        }

        return result;
    }
}
