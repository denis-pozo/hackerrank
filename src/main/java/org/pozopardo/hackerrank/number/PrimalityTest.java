package org.pozopardo.hackerrank.number;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimalityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        
        if(isPrime(n)){
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
        scanner.close();
    }

    static boolean isPrime(String n) {
        BigInteger bigInt = new BigInteger(n);
        return bigInt.isProbablePrime(1);
    }

}
