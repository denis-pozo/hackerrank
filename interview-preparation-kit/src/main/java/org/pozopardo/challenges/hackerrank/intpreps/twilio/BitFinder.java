package org.pozopardo.challenges.hackerrank.intpreps.twilio;

import java.io.IOException;

public class BitFinder {

    /*
     * Complete the 'fourthBit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER num as parameter.
     */

    public static int fourthBit(int num) {
        String binary = Integer.toBinaryString(num);
        System.out.println(num + " = " + binary);

        if(binary.length() < 4) {
            return 0;
        } else {
            return Character.getNumericValue(binary.charAt(binary.length() - 4));
        }
    }

    public static int fourthBitDiv(int num) {
        String binary = Integer.toBinaryString(num);
        System.out.println(num + " = " + binary);

        if(binary.length() < 4) {
            return 0;
        } else {
            return Character.getNumericValue(binary.charAt(binary.length() - 4));
        }
    }

    public static void main(String[] args) throws IOException {

        for(int i = 0 ; i < 100 ; i++) {
            System.out.println(fourthBit(i));

        }
    }
}
