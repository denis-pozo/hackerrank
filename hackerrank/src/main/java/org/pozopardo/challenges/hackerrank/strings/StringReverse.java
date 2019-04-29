package org.pozopardo.challenges.hackerrank.strings;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        sc.close();

        for(int i = 0 ; i < (A.length()-1)/2 ; i++) {
            if (Character.compare(A.charAt(i), A.charAt(A.length()-1-i)) != 0) {
                System.out.println("No");
                return;
            }
        }

        System.out.print("Yes");
    }
}
