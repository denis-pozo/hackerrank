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
        if(power < 0) {
            base = 1.0 / base;
            power = -power;
        }

        double result = 1.0;

        //Brute force algorithm O(2^n)
//        for(int i = 1 ; i < power ; i++) {
//            result = result * base;
//        }

        while(power > 0) {
            if((power & 1) == 1) {
                result *= base;
            }
            base *= base;
            power >>= 1;
        }

        return result;
    }
}
