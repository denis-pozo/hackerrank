package org.pozopardo.challenges.hackerrank.number;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        BigInteger aBig = new BigInteger(a);
        BigInteger bBig = new BigInteger(b);

        System.out.println(aBig.add(bBig));
        System.out.println(aBig.multiply(bBig));

        scanner.close();
    }
}
